package com.glut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author Caizhfy
 * @version v.0.1
 * @createTime 2017年9月11日下午10:56:29
 * @email Caizhfy@163.com
 * @description	在这里注册url静态路径映射，可以直接访问resources静态页面
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/**
		 * 这样的话如果要拿index.html只需要访问" 127.0.0.1:8080/${context}/index.html "
		 */
		registry.addResourceHandler("/**").addResourceLocations(
				ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
		/**
		 * 如果需要拿图片，图片路径就写" ./static/images/1.png "就可以相当于
		 * " 127.0.0.1/${context}/static/images/1.png "
		 * 
		 */
		registry.addResourceHandler("/static/**").addResourceLocations(
				ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
		super.addResourceHandlers(registry);
	}
}