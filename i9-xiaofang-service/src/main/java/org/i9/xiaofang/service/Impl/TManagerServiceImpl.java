package org.i9.xiaofang.service.Impl;

import org.i9.xiaofang.service.repository.model.TManager;
import org.i9.xiaofang.service.repository.mapper.TManagerMapper;
import org.i9.xiaofang.service.TManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    @Override
    public TManager checkManagerLogin(String userName, String password) {
        return null;
    }

}
