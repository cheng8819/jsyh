/*
package com.example.jsdengluprovider.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroSessionListener implements SessionListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroSessionListener.class);



    @Override
    public void onStart(Session session) {
        // 会话创建时触发
        LOGGER.info("ShiroSessionListener session {} 被创建", session.getId());
    }

    @Override
    public void onStop(Session session) {
        // 会话被停止时触发
        ShiroSessionRedisUtil.deleteSession(session);
        LOGGER.info("ShiroSessionListener session {} 被销毁", session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        //会话过期时触发
        ShiroSessionRedisUtil.deleteSession(session);
        LOGGER.info("ShiroSessionListener session {} 过期", session.getId());
    }
}
*/
