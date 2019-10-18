package com.bluewind.interceptor.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ProductInterceptorConfig implements WebMvcConfigurer {
	@Autowired
	ProductHandlerInterceptor productControllerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(productControllerInterceptor);
	}
}