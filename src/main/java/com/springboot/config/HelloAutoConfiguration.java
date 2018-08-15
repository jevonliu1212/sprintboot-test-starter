package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.service.HelloService;

@Configuration
@EnableConfigurationProperties(MyConfig.class)
@ConditionalOnClass(HelloService.class)//存在HelloService时初始化该配置类
@ConditionalOnProperty//存在对应配置信息时初始化该配置类
(
        prefix = "info",//存在配置前缀hello
        value = "enabled",//开启
        matchIfMissing = true//缺失检查
)
public class HelloAutoConfiguration {

	@Autowired
	private MyConfig myConfig;
	
	@Bean
	@ConditionalOnMissingBean(HelloService.class)
	public HelloService helloService(){
		System.out.println("the bean not found , create new bean...");
		HelloService service = new HelloService();
		service.setMsg(myConfig.getName());
		service.hi();
		return service;
	}
	
	
}
