package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		String viewName = getViewName(request);
		
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		//mav.setViewName("result");
		mav.setViewName(viewName);
	    System.out.println("ViewName:"+viewName);
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");

	    mav.addObject("id",id);
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
	    mav.setViewName("memberInfo");
	    return mav;
	}
	
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		return new ModelAndView(viewName);
	}
	
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		return new ModelAndView(viewName);
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
	    String contextPath = request.getContextPath();
	    System.out.println(contextPath);
	    String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	    if(uri == null || uri.trim().equals("")) {
	        uri = request.getRequestURI();
//	        System.out.println(uri);
	    }

	    int begin = 0;
	    if(!((contextPath==null)||("".equals(contextPath)))){
	        begin = contextPath.length();
	    }

	    int end;
	    if(uri.indexOf(";")!=-1){
	        end=uri.indexOf(";");
	    }else if(uri.indexOf("?")!=-1){
	    	end=uri.indexOf("?");
	    }else{
	        end=uri.length();
	    }

	    String fileName=uri.substring(begin,end);
	    if(fileName.indexOf(".")!=-1){
	        fileName=fileName.substring(0,fileName.lastIndexOf("."));
//	        System.out.println(fileName);
	    }
	    if(fileName.lastIndexOf("/")!=-1){
	    	fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
//	    	System.out.println(fileName);
	    }
		return fileName;
	}
}
