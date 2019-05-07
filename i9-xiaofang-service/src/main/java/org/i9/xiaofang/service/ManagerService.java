package org.i9.xiaofang.service;

import org.i9.xiaofang.service.repository.model.Manager;
import org.i9.xiaofang.service.repository.vo.LoginForm;
import org.i9.xiaofang.service.repository.vo.ManagerAddDto;
import org.i9.xiaofang.service.repository.vo.ManagerSearchDto;
import org.i9.xiaofang.util.BusinessException;
import org.i9.xiaofang.util.PageBounds;

import javax.validation.Valid;
import java.util.List;

public interface ManagerService {
    /**
     * 根据username查询
     * @Title: getManagerByName
     * @param @param username
     * @param @return
     * @param @throws BusinessException
     */
    Manager getManagerByName(String username) throws BusinessException;


    /**
     * 检查用户
     * @Title: checkManagerLogin
     * @param @param userName
     * @param @param password
     * @param @return
     */
    Manager checkManagerLogin(String userName, String password);

    /**
     * 分页查询
     * @Title: selectBylimitPage
     * @param @param managerSearchDto
     * @param @return
     */
    PageBounds<Manager> selectBylimitPage(ManagerSearchDto managerSearchDto) throws BusinessException;

    /**
     * 获取当前登录用户
     * @Title: getCurrentManager
     * @param @return
     * @param @throws BusinessException
     */
    Manager getCurrentManager()throws BusinessException;

    /**
     * updateById
     * @Title: updateManagerInfoById
     * @param @param manager
     * @param @throws BusinessException
     */
    void updateManagerInfoById(Manager manager)throws BusinessException;

    /**
     * 新增
     * @Title: insertManagerInfo
     * @param @param ManagerAddDto
     * @param @throws BusinessException
     */
    void insertManagerInfo(ManagerAddDto managerAddDto)throws BusinessException;

    /**
     * 删除
     * @Title: delManagerByIds
     * @param @param asList
     * @param @throws BusinessException
     */
    void delManagerByIds(List<Integer> asList)throws BusinessException;

    void login(@Valid LoginForm loginForm)throws BusinessException;
}
