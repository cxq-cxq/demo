package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//springBoot的启动应用程序，节省了Tomcat步骤
//所有带注解的文件只要在application的同级或者下一级就可以自动加载进来
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
