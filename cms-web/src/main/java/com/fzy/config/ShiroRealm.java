package com.fzy.config;

import com.fzy.service.LoginServer;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: ShiroRealm
 * @description:
 * @author: fzy
 * @date: 2019-02-16 11:23
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private LoginServer loginServer;

    /**
     * 用户授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 用户认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
