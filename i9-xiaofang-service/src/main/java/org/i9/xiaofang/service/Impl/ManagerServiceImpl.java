/**
 * FileName: ManagerServiceImpl
 * Author:   xph
 * Date:     2019/1/29 17:40
 * Description:
 */
package org.i9.xiaofang.service.Impl;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.i9.xiaofang.service.ManagerService;
import org.i9.xiaofang.service.repository.ManagerRepository;
import org.i9.xiaofang.service.repository.model.Manager;
import org.i9.xiaofang.service.repository.vo.LoginForm;
import org.i9.xiaofang.service.repository.vo.ManagerAddDto;
import org.i9.xiaofang.service.repository.vo.ManagerSearchDto;
import org.i9.xiaofang.util.BusinessException;
import org.i9.xiaofang.util.ErrorCode;
import org.i9.xiaofang.util.PageBounds;
import org.i9.xiaofang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019/1/29
 * @since 1.0.0
 */
@Service
public class ManagerServiceImpl  implements ManagerService{
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private HttpServletRequest request;

    @Override
    public Manager getManagerByName(String username) throws BusinessException {
        try {
            return managerRepository.getManagerByName(username);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Manager checkManagerLogin(String userName, String password)throws BusinessException {
        //根据username查询
        Manager manager = managerRepository.getManagerByName(userName);
        //验证登录账号
        if (manager == null) {
            throw new BusinessException("用户名输入错误!");
        }
        //将登录用户的密码转化后对比
        String newPsw = StringUtil.MD5(password);
        if(!manager.getPassword().equals(newPsw)) {
            throw new BusinessException("密码不正确!");
        }
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("userInfo", manager);
//		request.getSession().setAttribute("username", manager);
        return manager;
    }

    @Override
    public PageBounds<Manager> selectBylimitPage(ManagerSearchDto managerSearchDto) throws BusinessException{
        try {
            return managerRepository.selectBylimitPage(managerSearchDto);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"分页查询管理员失败！",e.getMessage());
        }
    }

    @Override
    public Manager getCurrentManager() throws BusinessException {
        try {
            Manager manager = (Manager) request.getSession().getAttribute("userInfo");
            return manager;
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"获取当前管理员失败！",e.getMessage());
        }
    }

    @Override
    public void updateManagerInfoById(Manager manager) throws BusinessException {
        try {
            managerRepository.updateManagerInfoById(manager);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"更新管理员失败！",e.getMessage());
        }
    }

    @Override
    public void insertManagerInfo(ManagerAddDto managerAddDto) throws BusinessException {
        if (!managerAddDto.getPassword().equals(managerAddDto.getConfirmPwd())) {
            throw new BusinessException(ErrorCode.CRUD_ERROR, "前后密码不一致");
        }
        try {
            Manager manager = new Manager();
            BeanUtils.copyProperties(manager, managerAddDto);
            manager.setCreatetime(StringUtil.dateToStringToS(new Date()));
            manager.setPassword(StringUtil.MD5(managerAddDto.getPassword()));
            managerRepository.insertManagerInfo(manager);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"新增管理员失败！",e.getMessage());
        }
    }

    @Override
    public void delManagerByIds(List<Integer> asList) throws BusinessException {
        try {
            managerRepository.delManagerByIds(asList);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"删除管理员失败！",e.getMessage());
        }
    }

    @Override
    public void login(@Valid LoginForm manager) throws BusinessException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(manager.getUsername(),
                StringUtil.MD5(manager.getPassword()));
        try {
            subject.login(token);
            Manager cManager = managerRepository.getManagerByName(manager.getUsername());
            Session shiroSession = subject.getSession();
            shiroSession.setAttribute("loginUser", cManager);
        } catch (IncorrectCredentialsException ice) {
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
