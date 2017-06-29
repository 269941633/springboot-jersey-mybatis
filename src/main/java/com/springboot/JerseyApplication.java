package com.springboot;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.springboot" ,"com.salt.api"})
public class JerseyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerseyApplication.class, args);
		System.out.println("启动成功");
	}

	/**
	 * 注册jerseyServlet，拦截/1.0/*所有url
	 * Date:2017年6月22日上午10:38:34
	 * @author Jfei
	 * @return
	 */
	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/1.0/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registration;
		}
}
