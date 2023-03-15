package com.blog.blogapidemo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiDemoApplication.class, args);
	}

}
