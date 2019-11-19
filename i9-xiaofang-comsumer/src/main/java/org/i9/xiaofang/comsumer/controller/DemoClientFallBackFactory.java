/**
 * FileName: DemoClientFallBackFactory
 * Author:   xph
 * Date:     2019/11/19 22:09
 * Description:
 */
package org.i9.xiaofang.comsumer.controller;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019/11/19
 * @since 1.0.0
 */
@Component
public class DemoClientFallBackFactory  implements FallbackFactory<ProducterClient>{

    @Override
    public ProducterClient create(Throwable throwable) {

        return new ProducterClient() {
            @Override
            public Map<String, Object> selectAllUsers() {
                System.out.println(throwable.toString());
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("errorMsg","段容器工厂 fallbackFactory");
                return hashMap;
            }
        };
    }
}
