package com.bluewind.interceptor.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ProductInterceptorConfig implements WebMvcConfigurer {
	@Autowired
	ProductHandlerInterceptor productControllerInterceptor;
	
	@Autowired
	MyHandlerInterceptor myHandlerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry of interceptors is necessary for interceptors to work
		registry.addInterceptor(productControllerInterceptor);
		//Add a second handler interceptor
		registry.addInterceptor(myHandlerInterceptor);
		
		/* The execution order of interceptor is as below:
		 *  Pre Handle method is Calling
			Pre Handle method is Calling in MyHandlerInterceptor
			Post Handle method is Calling in MyHandlerInterceptor
			Post Handle method is Calling
			Request and Response is completed in MyHandlerInterceptor
			Request and Response is completed
		 */
	}
}