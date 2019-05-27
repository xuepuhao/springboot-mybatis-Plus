package org.i9.xiaofang.service;

import org.i9.xiaofang.service.repository.model.TManager;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuepuhao
 * @since 2019-05-24
 */
public interface TManagerService extends IService<TManager> {

    TManager checkManagerLogin(String userName, String password);
}
