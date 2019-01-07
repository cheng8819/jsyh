package com.example.jsconsumerloans.feign;

import com.example.jsconsumerloans.feign.impl.ActivitiFeignImpl;
import com.example.jsconsumerloans.pojo.LeaveInfo;
import com.example.jsconsumerloans.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "JS-PRODUCER-LOANS",fallback = ActivitiFeignImpl.class)
public interface ActivitiFeign {
    //获取全部审核人
    @RequestMapping("/activiticontroller/getauditorsall")
    Result getAuditorsAll();

    //根据申请单id查询申请单
    @RequestMapping("/activiticontroller/findleaveinfobyid/{id}")
    Result findLeaveInfoById(@PathVariable("id") String id);

    //修改申请单状态
    @PostMapping("/activiticontroller/updateleaveinfostate")
    Result updateLeaveInfoState(@RequestBody LeaveInfo leaveInfo);
}
