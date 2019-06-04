/**
 * FileName: loginController
 * Author:   xph
 * Date:     2019/1/28 10:38
 * Description: login
 */
package org.i9.xiaofang.web.controller;


import org.i9.xiaofang.service.TManagerService;
import org.i9.xiaofang.service.repository.vo.LoginForm;
import org.i9.xiaofang.util.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * 〈一句话功能简述〉<br> 
 * 〈login〉
 *
 * @author lenovo
 * @create 2019/1/28
 * @since 1.0.0
 */
@Controller
@RequestMapping("")
public class loginController {

    @Autowired
    private TManagerService tManagerService;

    @RequestMapping("/hello")
    public String hello(Model m){
        m.addAttribute("name","thymeleaf");
        return "login";
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login.zhtml", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute LoginForm loginForm) {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login.zhtml", method = RequestMethod.POST)
    public ModelAndView loginVeri(@Valid LoginForm loginForm, BindingResult bindingResult) {
        try {
            tManagerService.login(loginForm);
            return new ModelAndView("redirect:index.zhtml");
        } catch (BusinessException e) {
            // 身份验证失败
            return new ModelAndView("login").addObject("exception", e);
        }
    }

    @RequestMapping("/index.zhtml")
    public String index(){
        return "index";
    }
}
