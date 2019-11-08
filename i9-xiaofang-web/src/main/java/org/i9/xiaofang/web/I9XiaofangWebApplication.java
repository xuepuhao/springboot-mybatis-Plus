package org.i9.xiaofang.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@MapperScan("org.i9.xiaofang.service.repository.mapper")
@ComponentScan("org.i9.xiaofang")
@SpringBootApplication
public class I9XiaofangWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(I9XiaofangWebApplication.class, args);
	}

}

