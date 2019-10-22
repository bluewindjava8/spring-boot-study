package com.bluewind.filtertest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		logger.info("Starting a transaction for req : {}", req.getRequestURI());

		chain.doFilter(request, response);
		logger.info("Committing a transaction for req : {}", req.getRequestURI());
	}

	// other methods
}