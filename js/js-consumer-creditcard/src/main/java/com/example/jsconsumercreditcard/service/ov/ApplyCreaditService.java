package com.example.jsconsumercreditcard.service.ov;

import com.alibaba.fastjson.JSON;
import com.example.jsconsumercreditcard.entity.Auditor;
import com.example.jsconsumercreditcard.entity.LeaveInfo;
import com.example.jsconsumercreditcard.feign.ApplyCreditCardFeign;
import org.activiti.engine.*;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("leaveService")
public class ApplyCreaditService {

	@Resource
	private RuntimeService runtimeService;
	@Resource
	private TaskService taskService;
	@Resource
	private HistoryService historyService;
	@Autowired
	private static RepositoryService repositoryService;
	@Resource
	private ApplyCreditCardFeign applyCreditCardFeign;

	/**
	 * 启动流程
	 * 
	 */
	public void startProcess(String bizKey) {
		//第一个参数是指定启动流程的id,即要启动哪个流程 ;第二个参数是指业务id
		System.out.println("启动前-----");
		runtimeService.startProcessInstanceByKey("myProcess_1", bizKey);
		System.out.println("启动之后------");
	}
	
	/**
	 * 根据审批人id查询需要审批的任务
	 * @param userId
	 * @return
	 */
	public List<Task> findTaskByUserId(String userId) {
		List<Task> list = taskService.createTaskQuery().taskCandidateOrAssigned(userId).list();
		return list;
	}
	
	/**
	 * 审批
	 * @param taskId 审批的任务id
	 * @param userId 审批人的id
	 * @param audit  审批意见：通过（cg）or驳回（sb）
	 */
	 public String completeTaskByUser(String taskId,String userId,String audit) {
		 String str = "";
		 if(!"cg".equals(audit) && !"sb".equals(audit)){
			str = "审批内容有误";
			return str;
		 }
		 Map<String, Object> map = new HashMap<>();
		 //1、认领任务
		 try {
			 taskService.claim(taskId, userId);
		 }catch (ActivitiObjectNotFoundException e){
		 	str = "";
		 	return "未找到此任务";
		 }
		//2.完成任务
		 map.put("audit",audit);
		 taskService.complete(taskId, map);
		 if("cg".equals(audit)){
		 	str = "执行审批通过";
		 }else{
		 	str = "执行审批不通过";
		 }
		 return str;
	 }
	
	public List<String> findSh(){
	 	List<String> kf = new ArrayList<>();
	 	String result = (String) applyCreditCardFeign.getAuditorAll().getData();
	 	List<Auditor> auditors = JSON.parseArray(result,Auditor.class);
		for (Auditor auditor : auditors) {
			kf.add(auditor.getAname());
		}
	 	return  kf;
	}
	
	/**
	 * 修改申请单的状态
	 */
	public void changeStatus(DelegateExecution execution,String status) {

		String key = execution.getProcessBusinessKey();
		String result = (String) applyCreditCardFeign.selectOneLeaveInfo(key).getData();
		LeaveInfo entity = JSON.parseObject(result, LeaveInfo.class);
		applyCreditCardFeign.updateLeaveInfoStateByid(entity.getId(),entity.getStatus());
	}

	/**
	 * 贷款成功处理
	 * @param execution
	 */
	public void daikuan(DelegateExecution execution){
		String key = execution.getProcessBusinessKey();
		//LeaveInfo entity = new LeaveInfo();
//		LeaveInfo entity = leaveInfoDao.findLeaveInfoById(key);
//		LoansTransaction loansTransaction = loansTransactionDao.findLoansTransactionsByLiapplicationdata(entity.getLoansid());
//		loansTransaction.setListate(1);
//		loansTransactionDao.save(loansTransaction);

	}

	/**
	 * 根据流程id查看该流程是否结束
	 * @param processInstanceId
	 * @return
	 */
	public boolean queryProcessIsEnd(String processInstanceId){
		
		HistoricProcessInstance result = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		if(result != null && result.getStartTime() != null && result.getEndTime() != null) {
			return true;
		}
		return false;
	}

	/**
	 * 获取流程图
	 * @param processDefId
	 * @return
	 */
	public static InputStream findProcessPic(String processDefId) {
		ProcessDefinition result = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefId).singleResult();
		String name = result.getDiagramResourceName();
		InputStream inputStream = repositoryService.getResourceAsStream(result.getDeploymentId(), name);
		return inputStream;
	}
}
