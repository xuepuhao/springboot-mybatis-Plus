/**
 * FileName: LogRecordAspect
 * Author:   xph
 * Date:     2019/2/22 10:25
 * Description: 切面
 */
package org.i9.xiaofang.web.intercepter;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.i9.xiaofang.util.BindingResultException;
import org.i9.xiaofang.util.BusinessException;
import org.i9.xiaofang.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈切面〉
 *
 * @author lenovo
 * @create 2019/2/22
 * @since 1.0.0
 */

@Aspect // 表示一个切面bean
@Component // bean容器的组件注解。虽然放在contrller包里，但它不是控制器。如果注入service,但我们又没有放在service包里
@Order(1)  // 有多个日志时，ORDER可以定义切面的执行顺序（数字越大，前置越后执行，后置越前执行）
public class LogRecordAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

    //定义切入点
        /*1、execution 表达式主体
          2、第1个* 表示返回值类型  *表示所有类型
          3、包名  com.*.*.controller下
          4、第4个* 类名，com.*.*.controller包下所有类
          5、第5个* 方法名，com.*.*.controller包下所有类所有方法
          6、(..) 表示方法参数，..表示任何参数
          */
    @Pointcut("execution(* org.i9.xiaofang.web.controller..*(..))")
    public  void execudeService(){
    }

    @Around(value = "execudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{ //方法里面注入连接点
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.info("接收, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString == null ? "" : queryString);
        HashMap<String, Object> result = new HashMap<String, Object>();
        try {
            Object object = pjp.proceed();
            if (object instanceof HashMap) {
                HashMap<String, Object> data = (HashMap<String, Object>) object;
                result.put("result", 1);
                result.put("data", data);
                result.put("errorMsg", "");
            }else{
                return object;
            }
        } catch (BusinessException exception) {
            result = new HashMap<String, Object>();
            result.put("result", 0);
            result.put("errorMsg", exception.getErrorMessage());
            result.put("errorCode", exception.getErrorCode());
            exception.printStackTrace();
            logger.error("error, message: {}, errorMessage: {}, exception: {}",exception.getMessage(),exception.getErrorMessage(),exception.getExceptionMessage());
        } catch (BindingResultException exception) {
            result = new HashMap<String, Object>();
            result.put("result", -1);
            result.put("errorMsg",  "参数格式错误");
            exception.printStackTrace();
            logger.error(exception.getErrorMessage());
            if (uri.equals(Constants.S_LOGIN_PAGE)) {
                return new ModelAndView(Constants.S_LOGIN_URL).addObject("exception", exception);
            }/*else if (uri.equals(Constants.S_REGIST_URL)) {
                List<Role> roles = roleService.selectPartRole();
                return new ModelAndView(Constants.S_REGIST_URL).addObject("exception", exception).addObject("roles", roles);
            }*/
        } catch (Exception e) {
            result = new HashMap<String, Object>();
            result.put("result", 0);
            result.put("errorMsg", "系统错误");
            result.put("result", "");
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        logger.info("响应, url: {}, result: {}", url, result);
        return result;
    }
}
