package com.glut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Caizhfy
 * @version v.0.1
 * @createTime 2017年9月11日下午10:51:01
 * @email Caizhfy@163.com
 * @description 快速启动
 *
 */
@SpringBootApplication
@MapperScan(basePackages="com.party.*.mapper")
@EnableTransactionManagement(proxyTargetClass=true)
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
