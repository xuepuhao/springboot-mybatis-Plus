/**
 * FileName: SecurityRealm
 * Author:   xph
 * Date:     2019/1/29 9:51
 * Description: shiroRealm
 */
package org.i9.xiaofang.web.security;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.i9.xiaofang.service.ManagerService;
import org.i9.xiaofang.service.repository.model.Manager;
import org.i9.xiaofang.util.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br> 
 * 〈shiroRealm〉
 *
 * @author lenovo
 * @create 2019/1/29
 * @since 1.0.0
 */
public class SecurityRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(SecurityRealm.class);

    @Autowired
    private ManagerService managerService;

    //权限验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName =String.valueOf(token.getPrincipal());
        String password =new String((char[])token.getCredentials());
        Manager authentication =null;
        try {
            // 通过数据库验证
            authentication = managerService.checkManagerLogin(userName, password);
        } catch (BusinessException exception) {
            throw new AuthenticationException(exception.getErrorMessage());
        }
        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, password, getName());
        return authenticationInfo;
    }
}
