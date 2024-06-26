package com.soft.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.soft.vo.memberVO;

public class AdminInterceptor implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
	 response.setCharacterEncoding("UTF-8");
	 response.setContentType("text/html; charset=UTF-8");
	
		HttpSession session =request.getSession();
		PrintWriter out = response.getWriter();
		memberVO lvo = (memberVO)session.getAttribute("member");
		
		if(lvo.getAdminCk() != 1 || session == null) {
			session.invalidate();
			response.sendRedirect("/error/403error");
			
		return false;
	}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
