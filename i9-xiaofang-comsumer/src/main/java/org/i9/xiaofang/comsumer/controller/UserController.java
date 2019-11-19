package org.i9.xiaofang.comsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProducterClient producterClient;

    @HystrixCommand(fallbackMethod = "getUsernameFallback")
    @RequestMapping("/getAlluser")
    public Object getAlluser(){
        return restTemplate.getForObject("http://i9-xiaofang-web/t-user/selectAllUsers",String.class);
    }

    @RequestMapping("/getAlluser2")
    public Object getAlluser2(){
        return producterClient.selectAllUsers();
    }

    public Object getUsernameFallback() {
        return "fall back";
    }
}
