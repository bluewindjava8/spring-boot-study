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
	
	@Autowired
	HisHandlerInterceptor hisHandlerInterceptor;	

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		//registry of interceptors is necessary for interceptors to work
//		registry.addInterceptor(productControllerInterceptor);
//		//Add a second handler interceptor
//		registry.addInterceptor(myHandlerInterceptor);
//		
//		/* The execution order of interceptor is as below:
	
//		    Pre Handle method is Calling
//			Pre Handle method is Calling in MyHandlerInterceptor
//			Post Handle method is Calling in MyHandlerInterceptor
//			Post Handle method is Calling
//			Request and Response is completed in MyHandlerInterceptor
//			Request and Response is completed
	
//		 */
//	}
	
	
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		//registry of interceptors is necessary for interceptors to work
//		registry.addInterceptor(productControllerInterceptor);
//		//Add a second handler interceptor
//		registry.addInterceptor(myHandlerInterceptor);
//		//Add a third handler interceptor
//		registry.addInterceptor(hisHandlerInterceptor);		
//		
//		/*  The execution order of interceptor is as below:
//		  
//		 	Pre Handle method is Calling
//			Pre Handle method is Calling in MyHandlerInterceptor
//			Pre Handle method is Calling in HisHandlerInterceptor
//			Post Handle method is Calling in HisHandlerInterceptor
//			Post Handle method is Calling in MyHandlerInterceptor
//			Post Handle method is Calling
//			Request and Response is completed in HisHandlerInterceptor
//			Request and Response is completed in MyHandlerInterceptor
//			Request and Response is completed
//			
//		 */
//
//	}
	
	/*
	 * We can specify the interceptor-URL mapping.
	 * https://stackoverflow.com/questions/34970179/exclude-spring-request-handlerinterceptor-by-path-pattern
	 * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry of interceptors is necessary for interceptors to work
		registry.addInterceptor(productControllerInterceptor);
		//Add a second handler interceptor
		registry.addInterceptor(myHandlerInterceptor).addPathPatterns("/v1/**");
		//Add a third handler interceptor
		registry.addInterceptor(hisHandlerInterceptor).addPathPatterns("/v1/**").excludePathPatterns("/v1/products_list");

	}
	
	
}