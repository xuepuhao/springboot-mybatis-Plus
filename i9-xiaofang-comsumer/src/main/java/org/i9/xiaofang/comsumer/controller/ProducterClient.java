package org.i9.xiaofang.comsumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Component
@FeignClient(name = "i9-xiaofang-web")
public interface ProducterClient {

    @ResponseBody
    @RequestMapping("/t-user/selectAllUsers")
    Map<String,Object> selectAllUsers();
}
