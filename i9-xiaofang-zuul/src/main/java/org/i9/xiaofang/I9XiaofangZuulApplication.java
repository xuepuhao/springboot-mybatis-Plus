package org.i9.xiaofang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class I9XiaofangZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(I9XiaofangZuulApplication.class, args);
	}

}
