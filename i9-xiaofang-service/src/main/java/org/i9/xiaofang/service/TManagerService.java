package org.i9.xiaofang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.i9.xiaofang.service.repository.model.TManager;
import org.i9.xiaofang.service.repository.vo.LoginForm;
import org.i9.xiaofang.util.BusinessException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuepuhao
 * @since 2019-05-24
 */
public interface TManagerService extends IService<TManager> {

    TManager checkManagerLogin(String userName, String password) throws BusinessException;

    void login(LoginForm loginForm) throws  BusinessException;
}
