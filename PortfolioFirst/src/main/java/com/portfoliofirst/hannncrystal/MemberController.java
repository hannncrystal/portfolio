package com.portfoliofirst.hannncrystal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDTO member, Model model) {
		
		memberservice.memberRegister(member);
		
		//Model Instance
		model.addAttribute("member", memberservice.memberSearch(member));
		
		return "/member/joinOk";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberDTO member, HttpSession session, Model model) {
		
		MemberDTO mem = memberservice.memberSearch(member);
		if(mem == null) 
			//404 exception
			//return "/hannncrystal/resources/login.html";
			return "/exception";
		
		session.setAttribute("membersession", mem);
		
		model.addAttribute("member", mem);
		
		return "/homeBS";
	}
	
	@RequestMapping("/logout")
	public String logout(MemberDTO member, HttpSession session) {
		
		session.invalidate();
		
		return "/homeBS";
	}
	
	@RequestMapping(value = "/modifyForm")
	public ModelAndView modifyForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("membersession");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("member", member);
		//mav.addObject("member", memberservice.memberSearch(member));
		//modifyForm of RequestMapping and modifyForm of View are different
		mav.setViewName("/member/modifyForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(MemberDTO member, HttpSession session, Model model) {
				
		int result = memberservice.memberModify(member);
		
		if(result == 0) {
			return("/member/modiForm");
		} else { 
			MemberDTO mem = memberservice.memberSearch(member);
			
			session.setAttribute("membersession", mem);
			
			model.addAttribute("modified", mem);
			
			return "/member/modifyOk";
		}
		
	}
/*	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(MemberDTO member, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		MemberDTO mem = memberservice.memberModify(member);
		if(mem == null) {
			mav.setViewName("/modiForm");
		} else { 
			session.setAttribute("membersession", mem);
			
			//mav.addObject("modified", mem);
			mav.addObject("modified", memberservice.memberSearch(member));
			mav.setViewName("/modifyOk");
		}
		
		return mav;
	}
	*/
	@RequestMapping("/removeForm")
	public ModelAndView removeForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session =  request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("membersession");
		
		if(null == member){
			//interceptor 처리
			//mav.setViewName("redirect:/");
		} else{
			
			mav.addObject("member", member);
			mav.setViewName("/member/removeForm");
		}
		
		
		return mav;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String memRemove(MemberDTO member, HttpServletRequest request) {
		
		int result = memberservice.memberRemove(member);
		
		if(result == 0)
			return "/member/removeForm";
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/homeBS";
	}
}