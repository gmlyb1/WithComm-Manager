package com.soft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.soft.vo.memberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		HttpSession session = request.getSession();
		memberVO member = (memberVO)session.getAttribute("member");
		
		if(member == null) {
			response.sendRedirect("/account/login");
			return false;
		}
		
		if(member == null || member.getMe_grade() != "최고관리자") {
			response.sendRedirect("/");
			return false;
		}
		
		return true;
	}
}
