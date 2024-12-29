package com.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//配置项目允许使用事务
@EnableTransactionManagement
public class EasySpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(EasySpringApplication.class,args);
	}
}
