package org.i9.xiaofang.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//开启Eureka注册中心服务功能
@EnableEurekaServer
public class I9XiaofangEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(I9XiaofangEurekaApplication.class, args);
	}

}
