package org.i9.xiaofang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.i9.xiaofang.service.repository.model.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.i9.xiaofang.service.repository.vo.UserDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuepuhao
 * @since 2019-05-24
 */
public interface TUserService extends IService<TUser> {

    /**
     * 分页查询user
     * @param userDto
     * @return
     */
    IPage<TUser> selectByLimitPage(UserDto userDto);
}
