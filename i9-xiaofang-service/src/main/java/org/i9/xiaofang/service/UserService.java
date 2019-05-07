package org.i9.xiaofang.service;

import org.i9.xiaofang.service.repository.model.User;
import org.i9.xiaofang.util.BusinessException;

public interface UserService {

    User selectById(Integer id) throws BusinessException;

    /**
     * 验证用户
     * @param userName
     * @param password
     * @return
     * @throws BusinessException
     */
    User checkManagerLogin(String userName, String password)throws BusinessException;
}
