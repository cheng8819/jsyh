package com.example.jsspringzuul.filter;


import com.alibaba.fastjson.JSON;
import com.example.jsspringzuul.uitl.RedisUtil;
import com.example.jsspringzuul.uitl.TokenUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.nimbusds.jose.JOSEException;
import net.minidev.json.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Map;

@Component//组件化到spring
public class PreFilter extends ZuulFilter {

    @Resource
    private RedisUtil redisUtil;


    @Override
    public String filterType() {
        //过滤器类型 PRE ROUTE POST  这三个过滤器再执行过程中都有可能进入ERROR过滤器
        return FilterConstants.PRE_TYPE;
    }
    private RequestContext ctx;
    @Override
    public int filterOrder() {
        return 0;//同一过滤器的优先级 优先级再高也不会超过上一级过滤器  越小优先级越高，可以为负数。
    }

    @Override
    public boolean shouldFilter() {
        /*//是否开启当前过滤器  一般不直接指定true 或 false
        //一般使用
        RequestContext ctx = RequestContext.getCurrentContext(); //这个对象是给过滤器传递信息的。
        ctx.setSendZuulResponse(true);  //设置布尔值
        boolean b = ctx.sendZuulResponse();  //获取布尔值
        //布尔值来判断
        return b;*/
        ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = request.getRequestURI();
        if ("/tologin/login".equals(requestURI)) {
            return true;
        }

//        // TODO
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //String login = request.getParameter("login");
        Cookie[] cookies = request.getCookies();
        String sessionId = null;
        for (Cookie c : cookies) {
            if ("SESSIONID".equals(c.getName())) {
                sessionId = c.getValue();
            }
        }
        //System.out.println(redisUtil.get("REDIS_TOKEN"));
        System.out.println(sessionId);
        HttpSession session = RequestContext.getCurrentContext().getRequest().getSession();
        System.out.println("sessionid == " + session.getId());
        String token = (String) session.getAttribute("REDIS_TOKEN");
        if (sessionId != null && sessionId.equals(session.getId())) {
            System.out.println("token" + token);
            Map<String, Object> validMap = null;
                try {
                    validMap = TokenUtils.valid(token);
                int i = (int) validMap.get("Result");
                //i失败1 成功0  过期2
                // System.out.println(JSON.toJSONString(result));
                System.out.println(i);
                if (i == 0) {
                    System.out.println("token解析成功");
                    JSONObject jsonObject = (JSONObject) validMap.get("data");
                    System.out.println("uid=" + jsonObject.get("uid"));
                    System.out.println("sta=" + jsonObject.get("sta"));
                    System.out.println("exp=" + jsonObject.get("exp"));
                    return null;
                } else if (i == 1) {
                    ctx.setSendZuulResponse(false);
                    ctx.setResponseStatusCode(403);
                    ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
                    ctx.setResponseBody("认证失败");
                } else if (i == 2) {
                    ctx.setSendZuulResponse(false);
                    ctx.setResponseStatusCode(403);
                    ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
                    ctx.setResponseBody("已过期请重新登陆");
                    session.invalidate();
                } else if(token==null){
                    ctx.setSendZuulResponse(false);
                    ctx.setResponseStatusCode(403);
                    ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
                    ctx.setResponseBody("未登录，请先登录");
                }
                } catch (Exception e) {
                    e.printStackTrace();
                    ctx.setSendZuulResponse(false);
                    ctx.setResponseStatusCode(403);
                    ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
                    ctx.setResponseBody("未登录，请先登录");
                }

        /*if (login == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            ctx.setResponseBody("非法访问");
        }*/

        }else{
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
            ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            ctx.setResponseBody("未登录，请先登录");
            return token;
        }
        return "1234";

    }


}