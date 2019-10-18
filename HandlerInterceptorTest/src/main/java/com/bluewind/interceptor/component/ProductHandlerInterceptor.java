package com.bluewind.interceptor.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ProductHandlerInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Pre Handle method is Calling");

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		/*
		 * HandlerInterceptorAdapters can not working with @ResponseBody, @RestController and ResponseEntity methods. (but it works with @Controller)
		 * Use ResponseBodyAdvice with @ControllerAdvice instead. Refer to the following link:
		 * https://stackoverflow.com/questions/48823794/spring-interceptor-doesnt-add-header-to-restcontroller-services
		 */
		response.addHeader("product", "product_header");

		System.out.println("Post Handle method is Calling");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		System.out.println("Request and Response is completed");
	}
}
