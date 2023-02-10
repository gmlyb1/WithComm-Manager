package com.soft.Listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.soft.dao.VisitCountDAO;
import com.soft.vo.VisitCountVO;

public class VisitCounter implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		VisitCountDAO visitCountDAO = (VisitCountDAO)wac.getBean("visitCountDAO");
		VisitCountVO vo = new VisitCountVO();
		 vo.setVisit_ip(request.getRemoteAddr());
         vo.setVisit_agent(request.getHeader("User-Agent"));//브라우저 정보
         vo.setVisit_refer(request.getHeader("referer"));//접속 전 사이트 정보
         try {
			visitCountDAO.insertVisitor(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

}
