package com.portfoliofirst.hannncrystal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			Object obj = session.getAttribute("membersession");
			if(obj != null) 
				return true;
		}
		
		response.sendRedirect(request.getContextPath() + "/exception");
		return false;
		
//		String id = (String)request.getSession().getAttribute("membersession");
//		
//		if(id==null) {
//			response.sendRedirect(request.getContextPath() + "/exception");
//			return false;
//		}
//		
//		return true;	

	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		super.afterCompletion(request, response, handler, ex);
	}

}
