/**
 * FileName: UserRepository
 * Author:   xph
 * Date:     2019/1/28 10:47
 * Description:
 */
package org.i9.xiaofang.service.repository;


import org.i9.xiaofang.service.repository.mapper.UserMapper;
import org.i9.xiaofang.service.repository.model.User;
import org.i9.xiaofang.service.repository.model.UserExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019/1/28
 * @since 1.0.0
 */
@Repository
public class UserRepository {

    @Resource
    private UserMapper userMapper;

    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User getUserByUsername(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        return null;
    }
}
