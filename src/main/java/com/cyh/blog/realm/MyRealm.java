package com.cyh.blog.realm;

import com.cyh.blog.entity.User;
import com.cyh.blog.service.impl.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cai on 2017/6/20.
 */
public class MyRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorInfo = new SimpleAuthorizationInfo();
        authorInfo.setRoles(userService.getRolesByUserName(userName));
        authorInfo.setStringPermissions(userService.getPermissionsByUserName(userName));
        return authorInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String)authenticationToken.getPrincipal();
        User user = userService.getByUserName(userName);
        if(user == null){
            throw new UnknownAccountException();
        }
        if(Boolean.TRUE.equals(user.getLocked())){
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenInfo = new SimpleAuthenticationInfo(user.getUsername() , user.getPassword() , "myrealm");
        authenInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername() + user.getSalt()));
        return  authenInfo;
    }
}
