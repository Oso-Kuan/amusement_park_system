package com.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//������Ŀ����ʹ������
@EnableTransactionManagement
public class EasySpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(EasySpringApplication.class,args);
	}
}
