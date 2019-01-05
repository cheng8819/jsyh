/*
package com.example.jsdengluprovider.dao;


import com.example.jsdengluprovider.service.impl.RedisUtil;
import com.example.jsdengluprovider.util.Const;
import com.example.jsdengluprovider.util.ShiroSessionRedisConstant;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.tomcat.jni.User;

import java.io.Serializable;

import static com.example.jsdengluprovider.util.ShiroSessionConvertUtil.byteToSession;
import static com.example.jsdengluprovider.util.ShiroSessionConvertUtil.sessionToByte;
import static com.example.jsdengluprovider.util.ShiroSessionRedisConstant.SHIROSESSION_REDIS_DB;
import static com.example.jsdengluprovider.util.ShiroSessionRedisConstant.SHIROSESSION_REDIS_EXTIRETIME;
import static com.example.jsdengluprovider.util.ShiroSessionRedisConstant.SHIROSESSION_REDIS_PREFIX;

public class ShiroSessionRedisDao extends EnterpriseCacheSessionDAO {

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        RedisUtil.setObject(SHIROSESSION_REDIS_DB, (SHIROSESSION_REDIS_PREFIX + sessionId.toString()).getBytes(), sessionToByte(session), SHIROSESSION_REDIS_EXTIRETIME);

        return sessionId;
    }


    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        return this.doReadSession(sessionId);
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = null;
        byte[] bytes = RedisUtil.getObject(SHIROSESSION_REDIS_DB, (SHIROSESSION_REDIS_PREFIX + sessionId.toString()).getBytes(), SHIROSESSION_REDIS_EXTIRETIME);
        if (bytes != null && bytes.length > 0) {
            session = byteToSession(bytes);
        }
        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        RedisUtil.updateObject(SHIROSESSION_REDIS_DB, (SHIROSESSION_REDIS_PREFIX + session.getId().toString()).getBytes(), sessionToByte(session), SHIROSESSION_REDIS_EXTIRETIME);
        //也要更新token
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (null != user) {
            RedisUtil.updateString(SHIROSESSION_REDIS_DB, ShiroSessionRedisConstant.SSOTOKEN_REDIS_PREFIX + user.getUSERNAME(), SHIROSESSION_REDIS_EXTIRETIME);
        }
    }

    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        RedisUtil.delString(SHIROSESSION_REDIS_DB, SHIROSESSION_REDIS_PREFIX + session.getId().toString());
        //也要删除token
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (null != user) {
            RedisUtil.delString(SHIROSESSION_REDIS_DB, ShiroSessionRedisConstant.SSOTOKEN_REDIS_PREFIX + user.getUSERNAME());
        }
    }
}*/
