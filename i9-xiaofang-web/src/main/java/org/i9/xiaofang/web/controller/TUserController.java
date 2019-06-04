package org.i9.xiaofang.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.i9.xiaofang.service.TUserService;
import org.i9.xiaofang.service.repository.model.TUser;
import org.i9.xiaofang.service.repository.vo.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuepuhao
 * @since 2019-05-24
 */
@Controller
@RequestMapping("//t-user")
public class TUserController {

    @Autowired
    private TUserService tUserService;

    /**
     * 查询全部
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectAllUsers")
    public Map<String,Object> selectAllUsers() {
        HashMap<String, Object> hashMap = new HashMap<>();
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","新");
        List<TUser> users = tUserService.list(queryWrapper);
        hashMap.put("users", users);
        return hashMap;
    }

    /**
     * 分页查询
     * @param userDto
     * @return
     */
    @ResponseBody
    @RequestMapping("/openTable")
    public Map<String,Object> openTable(UserDto userDto) {
        HashMap<String, Object> hashMap = new HashMap<>();
        IPage<TUser> users= tUserService.selectByLimitPage(userDto);
        hashMap.put("users", users);
        return hashMap;
    }


}
