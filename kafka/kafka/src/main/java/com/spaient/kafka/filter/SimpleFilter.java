package com.spaient.kafka.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Remote Host:"+request.getRemoteHost());
		logger.info("Remote Address:"+request.getRemoteAddr());
	    chain.doFilter(request, response);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Servlet filter init method");
	}
	
	 public void destroy() {
		 logger.info("Servelet Filter destory method");
	 }

}
