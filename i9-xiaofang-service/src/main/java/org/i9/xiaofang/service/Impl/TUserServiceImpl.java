package org.i9.xiaofang.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.i9.xiaofang.service.TUserService;
import org.i9.xiaofang.service.repository.mapper.TUserMapper;
import org.i9.xiaofang.service.repository.model.TUser;
import org.i9.xiaofang.service.repository.vo.UserDto;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public IPage<TUser> selectByLimitPage(UserDto userDto) {
        try {
            Page<TUser> page = new Page<>(userDto.getCurrentPage(), userDto.getPageSize());
            QueryWrapper<TUser> wrappser = new QueryWrapper<>();
            wrappser.like("name",userDto.getName());
            tUserMapper.selectMapsPage(page,wrappser);
            return page;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
