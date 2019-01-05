/*
package com.example.jsdengluprovider.util;


import com.example.jsdengluprovider.service.impl.RedisUtil;
import org.apache.shiro.session.Session;


import java.io.Serializable;

import static com.example.jsdengluprovider.util.ShiroSessionConvertUtil.byteToSession;
import static com.example.jsdengluprovider.util.ShiroSessionRedisConstant.SHIROSESSION_REDIS_DB;
import static com.example.jsdengluprovider.util.ShiroSessionRedisConstant.SHIROSESSION_REDIS_EXTIRETIME;
import static com.example.jsdengluprovider.util.ShiroSessionRedisConstant.SHIROSESSION_REDIS_PREFIX;

public class ShiroSessionRedisUtil {

    public static Session getSession(Serializable sessionId){
        Session session = null;
        byte[] bytes = RedisUtil.getObject(SHIROSESSION_REDIS_DB,(SHIROSESSION_REDIS_PREFIX+sessionId.toString()).getBytes(),SHIROSESSION_REDIS_EXTIRETIME);
        if(bytes != null && bytes.length > 0){
            session = byteToSession(bytes);
        }
        return session;
    }
    public static void updateSession(Session session){
        RedisUtil.updateObject(SHIROSESSION_REDIS_DB,(SHIROSESSION_REDIS_PREFIX+session.getId().toString()).getBytes(),ShiroSessionConvertUtil.sessionToByte(session),SHIROSESSION_REDIS_EXTIRETIME);
        //也要更新token
        //User user = (User)session.getAttribute(Const.SESSION_USER);
        //if(null != user){
          //  RedisUtil.updateString(SHIROSESSION_REDIS_DB,ShiroSessionRedisConstant.SSOTOKEN_REDIS_PREFIX+user.getUSERNAME(),SHIROSESSION_REDIS_EXTIRETIME);
        //}
    }

    public static void deleteSession(Session session){
        RedisUtil.delString(SHIROSESSION_REDIS_DB,SHIROSESSION_REDIS_PREFIX+session.getId().toString());
        //也要删除token
        //User user = (User)session.getAttribute(Const.SESSION_USER);
//        if(null != user){
//            RedisUtil.delString(SHIROSESSION_REDIS_DB,ShiroSessionRedisConstant.SSOTOKEN_REDIS_PREFIX+user.getUSERNAME());
//        }
    }
}*/
