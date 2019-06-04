/**
 * FileName: SecurityRealm
 * Author:   xph
 * Date:     2019/1/29 9:51
 * Description: shiroRealm
 */
package org.i9.xiaofang.web.security;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.i9.xiaofang.service.TManagerService;
import org.i9.xiaofang.service.repository.model.TManager;
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
    private TManagerService tManagerService;

    //权限验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName =String.valueOf(token.getPrincipal());
        TManager authentication =null;
        QueryWrapper<TManager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userName);
        authentication = tManagerService.getOne(queryWrapper);
        if (authentication == null) {
            throw  new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, authentication.getPassword(), getName());
        return authenticationInfo;
    }
}
