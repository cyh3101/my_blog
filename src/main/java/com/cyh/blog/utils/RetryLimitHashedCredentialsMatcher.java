package com.cyh.blog.utils;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cai on 2017/6/20.
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{

    private Cache<String , AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager){
        this.passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String userName = (String)token.getPrincipal();
        AtomicInteger retryCount = this.passwordRetryCache.get(userName);
        if(retryCount == null){
            retryCount = new AtomicInteger(0);
            this.passwordRetryCache.put(userName , retryCount);
        }
        System.out.println(retryCount.get());
        if(retryCount.incrementAndGet() > 5){
            throw new ExcessiveAttemptsException();
        }
        System.out.println(retryCount.get());
        boolean matches =  super.doCredentialsMatch(token, info);
        if(matches){
            passwordRetryCache.remove(userName);
        }
        return matches;
    }
}
