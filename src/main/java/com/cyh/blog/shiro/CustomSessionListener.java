package com.cyh.blog.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * Created by cai on 2017/6/25.
 */
public class CustomSessionListener implements SessionListener{
    public void onStart(Session session) {
        System.out.println("session on start");
    }

    public void onStop(Session session) {
        System.out.println("session on stop");
    }

    public void onExpiration(Session session) {
        System.out.println("session on expiration");
    }
}
