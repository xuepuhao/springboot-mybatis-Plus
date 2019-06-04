package org.i9.xiaofang.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.i9.xiaofang.service.TManagerService;
import org.i9.xiaofang.service.repository.mapper.TManagerMapper;
import org.i9.xiaofang.service.repository.model.TManager;
import org.i9.xiaofang.service.repository.vo.LoginForm;
import org.i9.xiaofang.util.BusinessException;
import org.i9.xiaofang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuepuhao
 * @since 2019-05-24
 */
@Service
public class TManagerServiceImpl extends ServiceImpl<TManagerMapper, TManager> implements TManagerService {

    @Autowired
    private TManagerMapper tManagerMapper;

    @Override
    public TManager checkManagerLogin(String userName, String password) throws BusinessException{

        return null;
    }

    @Override
    public void login(LoginForm loginForm) throws BusinessException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUsername(), StringUtil.MD5(loginForm.getPassword()));
        try {
            subject.login(token);
            Session Shirosession = subject.getSession();
            Shirosession.setAttribute("loginUser", Shirosession);
        }catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            throw new BusinessException("密码错误");
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            throw new BusinessException("帐号不存在");
        } catch (LockedAccountException eae) {
            // 帐号被锁定
            throw new BusinessException("帐号被锁定");
        } catch (Exception e) {
            throw new BusinessException("查询失败");
        }
    }
}
