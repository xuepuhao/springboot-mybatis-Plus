/**
 * FileName: DruidConfig
 * Author:   xph
 * Date:     2019/1/28 15:53
 * Description: druid连接池配置
 */
package org.i9.xiaofang.web.config;


import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.assertj.core.util.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈druid连接池的配置,配置如何处理慢sql，〉
 *
 * @author lenovo
 * @create 2019/1/28
 * @since 1.0.0
 */
@Configuration
public class DruidConfig {
    //这个注解读取配置文件前缀为prefix的配置，将外部的配置文件与这里绑定
    @ConfigurationProperties(prefix = "spring.druid")
    //容器的开启与关闭
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return  dataSource;
    }
    //bean注解，成为spring的bean，利用filter将慢sql的日志打印出来
    @Bean
    public Filter statFilter(){
        StatFilter statFilter=new StatFilter();
        //多长时间定义为慢sql，这里定义为5s
        statFilter.setSlowSqlMillis(5000);
        //是否打印出慢日志
        statFilter.setLogSlowSql(true);
        //是否将日志合并起来
        statFilter.setMergeSql(true);
        return  statFilter;
    }
    //这是配置druid的监控
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    }
}
