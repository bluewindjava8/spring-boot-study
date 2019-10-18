package com.bluewind.interceptor.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyHandlerInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Pre Handle method is Calling in MyHandlerInterceptor");

		return true;
		//return false;
		
		/* true if the execution chain should proceed with thenext interceptor or the handler itself. 
		 * Else, DispatcherServlet assumesthat this interceptor has already dealt with the response itself.
		 * 
		 * If we return false the the second interceptor, the third interceptor will not be called. 
		 * This execution order is as below and there is no contents in the response.
		 * 
		 *  Pre Handle method is Calling
			Pre Handle method is Calling in MyHandlerInterceptor
			Request and Response is completed
		 */
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.addHeader("my", "my_header");
		System.out.println("Post Handle method is Calling in MyHandlerInterceptor");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		
		System.out.println("Request and Response is completed in MyHandlerInterceptor");
	}
}
