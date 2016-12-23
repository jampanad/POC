package com.nisum.test.dataRest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CORSResponseFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
		resp.addHeader("Access-Control-Max-Age", "3600");
		resp.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Access-Control-Allow-Origin,Authorization");
		chain.doFilter(request, servletResponse);
	}

	@Override
	public void destroy() {
	}
}