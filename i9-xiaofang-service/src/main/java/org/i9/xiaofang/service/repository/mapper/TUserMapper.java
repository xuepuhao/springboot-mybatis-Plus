package org.i9.xiaofang.service.repository.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.i9.xiaofang.service.repository.model.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.i9.xiaofang.service.repository.vo.UserDto;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuepuhao
 * @since 2019-05-24
 */
public interface TUserMapper extends BaseMapper<TUser> {

    List<TUser> selectByLimitPage(Page<TUser> page,@Param("example") UserDto userDto);
}
