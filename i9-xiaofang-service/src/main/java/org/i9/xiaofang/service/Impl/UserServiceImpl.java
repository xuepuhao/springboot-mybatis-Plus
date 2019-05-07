/**
 * FileName: UserServiceImpl
 * Author:   xph
 * Date:     2019/1/28 10:46
 * Description:
 */
package org.i9.xiaofang.service.Impl;


import org.i9.xiaofang.service.UserService;
import org.i9.xiaofang.service.repository.UserRepository;
import org.i9.xiaofang.service.repository.model.User;
import org.i9.xiaofang.util.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019/1/28
 * @since 1.0.0
 */
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User selectById(Integer id) throws BusinessException {
        try {
            return userRepository.selectById(id);
        }catch (Exception e){
            throw  new BusinessException("id查询失败",e.getMessage());
        }
    }

    @Override
    public User checkManagerLogin(String userName, String password) throws BusinessException {
        //通过username查询
        User user =userRepository.getUserByUsername(userName);
        return user;
    }
}
