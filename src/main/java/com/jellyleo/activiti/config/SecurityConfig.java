/**
 * Created by Jellyleo on 2019年12月16日
 * Copyright © 2019 jellyleo.com 
 * All rights reserved. 
 */
package com.jellyleo.activiti.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * 功能描述: Spring Security验证配置
 *
 * @author Jelly
 * @created 2019年11月19日
 * @version 1.0.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// 禁用CSRF保护
		security.csrf().disable();
		security.authorizeRequests()// 对请求授权
				.antMatchers("/doc.html","/webjars/**","/img.icons/**","/swagger-resources/**","/**","/v2/api-docs").permitAll() //允许所有人访问knife4j
				.anyRequest() // 任何请求
				.authenticated()// 需要身份认证
		;
	}
}
