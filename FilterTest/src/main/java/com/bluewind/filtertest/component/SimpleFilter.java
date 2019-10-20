package com.bluewind.filtertest.component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.stereotype.Component;

@Component
public class SimpleFilter implements Filter {

	/*
	 * doFilter method will only be executed once during one request/reponse pair.
	 * Servlet will be invoked within chain.doFilter method finally, then chain.doFilter will return.
	 * So we can add headers to response after the chain.doFilter returns.
	 * http://otndnld.oracle.co.jp/document/products/as10g/101300/B25221_03/web.1013/b14426/filters.htm
	 */
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		HttpServletResponse resp = (HttpServletResponse) response;
//
//		System.out.println("Remote Host:" + request.getRemoteHost());
//		System.out.println("Remote Address:" + request.getRemoteAddr());
//
//		chain.doFilter(request, response);
//		System.out.println("Response headers: " + resp.getHeaderNames());
//		
//		
//		/*
//		 * 
//		After filterChain.doFilter is called it's too late to do anything with the response. 
//		At this point, the entire response was already sent to the client.
//		The method to add response header below won't work.
//		 */
//		resp.addHeader("extra-header", "Extra Header");
//	}
	
	
	
	/*
	 * Use HttpServletResponseWrapper to add extra header in response.
	 * https://stackoverflow.com/questions/32829124/adding-header-in-response-in-filter
	 * https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServletResponseWrapper.html
	 * 
	 * Similarly, we can extends HttpServletRequestWrapper to add new header in request. 
	 * (Not the my code below. Refer to the link below) 
	 * https://stackoverflow.com/questions/2811769/adding-an-http-header-to-the-request-in-a-servlet-filter/23590606
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletResponseWrapper respWrapper = new HttpServletResponseWrapper(resp);
		respWrapper.addHeader("extra-header", "Extra Header");

		System.out.println("Remote Host:" + request.getRemoteHost());
		System.out.println("Remote Address:" + request.getRemoteAddr());

		chain.doFilter(request, respWrapper);
		System.out.println("Response headers: " + resp.getHeaderNames());
		
		
	}

}
