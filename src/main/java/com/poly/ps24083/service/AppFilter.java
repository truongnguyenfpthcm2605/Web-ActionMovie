package com.poly.ps24083.service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "app", urlPatterns = "/*")
public class AppFilter implements HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);

	}
	
}
