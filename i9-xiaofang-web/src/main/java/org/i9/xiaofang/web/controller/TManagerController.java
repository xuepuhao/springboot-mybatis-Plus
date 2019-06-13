package org.i9.xiaofang.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
@RequestMapping("//t-manager")
public class TManagerController {


    @ResponseBody
    @RequestMapping("/selectAllUsers")
    public Map<String,Object> selectAllUsers() {
        HashMap<String, Object> hashMap = new HashMap<>();
        int[] datas={5,10,20,30,5,2,6,12};
        String[] dataTypes={"日销量","月销量"};
        return hashMap;
    }

}
