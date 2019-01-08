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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
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
//        if("/tologin/login".equals(requestURI)||"/tologin/toa".equals(requestURI)
//                ||"/tologin//getNamePhone".equals(requestURI)||"/tologin/loginsms".equals(requestURI)
//                ||"tologin/VerifyTheLoginVerificationCode".equals(requestURI)){
//            System.out.println(request.getSession().getId());
//            return false;
//        }
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie c :cookies){
                if (c.getName().equals("TOKEN")){
                    token = c.getValue();
                }
            }
        }
        ctx.addZuulRequestHeader("TOKEN",token);
        if ("tologin/toa".equals(requestURI)){
            return true;
        }
        //ctx.addZuulRequestHeader("phone",String.valueOf(jsonObject.get("phone")));
        System.out.println("aaaaaaaaaaaaaa" + request.getSession().getId());

//        // TODO
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctxs = RequestContext.getCurrentContext();
        HttpServletRequest request = ctxs.getRequest();
        //HttpSession sess = request.getSession().getSessionContext().getSession("62838764-3112-4588-8a05-698b97baae28");
        //String login = request.getParameter("login");
        Cookie[] cookies = request.getCookies();
        String sessionId = null;
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return null;
        }
//        for (Cookie c : cookies) {
//            if ("SESSION".equals(c.getName())) {
//                sessionId = c.getValue();
//            }
//        }

        //System.out.println(redisUtil.get("REDIS_TOKEN"));
        //System.out.println(sessionId);
        HttpSession session = request.getSession();
        System.out.println("sessionid == " + session.getId());
        //String token = (String) session.getAttribute("REDIS_TOKEN");
        String token = null;

        if (cookies!=null){
            for (Cookie c :cookies){
                if (c.getName().equals("TOKEN")){
                    token = c.getValue();
                }
            }
        }
        //if (sessionId != null && sessionId.equals(session.getId())) {
            if (token!=null) {
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
                    System.out.println("uid=" + jsonObject.get("phone"));
                    System.out.println("sta=" + jsonObject.get("idcard"));
                    System.out.println("exp=" + jsonObject.get("exp"));
                    //生成时间
                    ctxs.addZuulRequestHeader("idcard", String.valueOf(jsonObject.get("idcard")));
                    Map<String, Object> map = new HashMap<>();
                    //建立载荷，这些数据根据业务，自己定义。
                    map.put("phone", jsonObject.get("phone"));
                    map.put("idcard", jsonObject.get("idcard"));
                    //生成时间
                    map.put("sta", new Date().getTime());
                    //过期时间
                    map.put("exp", new Date().getTime() + 1000 * 60 * 1);
                    String newToken = TokenUtils.creatToken(map);
                    //session.setAttribute("REDIS_TOKEN",newToken);
                    Cookie cookie  = new Cookie("TOKEN",newToken);
                    //ctxs.addZuulRequestHeader("userid", String.valueOf("121"));
                    cookie.setMaxAge(1000*60);
                    cookie.setPath("/");
                    HttpServletResponse response = ctxs.getResponse();
                    response.addCookie(cookie);
                    System.out.println(newToken);
                    System.out.println(JSON.toJSONString(validMap));
                    return null;
                } else if (i == 1) {

                    //ctxs.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
                    ctxs.setResponseBody("认证失败");
                    Cookie cookie  = new Cookie("TOKEN",null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    HttpServletResponse response = ctxs.getResponse();
                    response.addCookie(cookie);
                } else if (i == 2) {
                    //ctxs.setSendZuulResponse(false);
                    //ctxs.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
                    ctxs.setResponseBody("已过期请重新登陆");
                    Cookie cookie  = new Cookie("TOKEN",null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    HttpServletResponse response = ctxs.getResponse();
                    response.addCookie(cookie);
                    session.invalidate();
                } else if(token==null){
                    //ctxs.setSendZuulResponse(false);
//                    ctxs.setResponseStatusCode(403);
                   // ctxs.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
                    ctxs.setResponseBody("未登录，请先登录");
                    Cookie cookie  = new Cookie("TOKEN",null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    HttpServletResponse response = ctxs.getResponse();
                    response.addCookie(cookie);
                }
                } catch (Exception e) {
                    e.printStackTrace();

                   // ctxs.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
                    ctxs.setResponseBody("未登录，请先登录");
                    Cookie cookie  = new Cookie("TOKEN",null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    HttpServletResponse response = ctxs.getResponse();
                    response.addCookie(cookie);
                }

        /*if (login == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            ctx.setResponseBody("非法访问");
        }*/

        }else{
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(404);
            ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            ctx.setResponseBody("未登录，请先登录");
                Cookie cookie  = new Cookie("TOKEN",null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                HttpServletResponse response = ctxs.getResponse();
                response.addCookie(cookie);
            return token;
        }
        return "1234";

    }


}