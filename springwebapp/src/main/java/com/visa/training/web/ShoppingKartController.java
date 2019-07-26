package com.visa.training.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//String uri = request.getRequestURI();
//HttpSession session = request.getSession();
//if(uri.endsWith("addbooks")) {
//	String selectedbooks[]=request.getParameterValues("books");
//	session.setAttribute("selectedbooks", selectedbooks);
//	request.getRequestDispatcher("cars.html").forward(request,response);
//
//}else
//if(uri.endsWith("addcars")) {
//	String selectedcars[]=request.getParameterValues("cars");
//	session.setAttribute("selectedcars", selectedcars);
//	request.getRequestDispatcher("bikes.html").forward(request,response);
//
//}else
//if(uri.endsWith("addbikes")) {
//	String selectedbikes[]=request.getParameterValues("bikes");
//	String selectedbooks[]=(String[])session.getAttribute("selectedbooks");
//	String selectedcars[]=(String[])session.getAttribute("selectedcars");
//	
//	
//	request.getRequestDispatcher("cart_el.jsp").forward(request, response);

@Controller
@SessionAttributes({"selectedbooks","selectedcars","selectedbikes"})
public class ShoppingKartController {
	
	@RequestMapping("/addbooks")
	
	public String addbooks(@RequestParam("books") String [] selectedbooks, Map model  ) {
		String viewname = "cars";
		//String uri = request.getRequestURI();
		//HttpSession session = request.getSession();
		//if(uri.endsWith("addbooks")) {
			//String selectedbooks[]=request.getParameterValues("books");
			model.put("selectedbooks", selectedbooks);
			//request.getRequestDispatcher("cars.html").forward(request,response);
		
//		}else
//		if(uri.endsWith("addcars")) {
//			String selectedcars[]=request.getParameterValues("cars");
//			session.setAttribute("selectedcars", selectedcars);
//			request.getRequestDispatcher("bikes.html").forward(request,response);
//		
//		}else
//		if(uri.endsWith("addbikes")) {
//			String selectedbikes[]=request.getParameterValues("bikes");
//			String selectedbooks[]=(String[])session.getAttribute("selectedbooks");
//			String selectedcars[]=(String[])session.getAttribute("selectedcars");
//			
//			
//			request.getRequestDispatcher("cart_el.jsp").forward(request, response);
			
			
			return "cars";
	}
		@RequestMapping("/addcars")
		public String addcars(@RequestParam("cars") String[] selectedcars,Map model) {
			
			String viewname = "bikes";
			//String uri = request.getRequestURI();
			//HttpSession session = request.getSession();
			//if(uri.endsWith("addbooks")) {
				//String selectedbooks[]=request.getParameterValues("books");
		model.put("selectedcars", selectedcars);
			//Map<String,Object> attributes = new HashMap<String,Object>();
			//attributes.put("Session",session);
			return  viewname;
		}
		
		@RequestMapping("/addbikes")
		public String addbikes( @RequestParam("bikes") String[] selectedbikes, Map model) {
			String viewname = "cart_el";
			//String uri = request.getRequestURI();
			//HttpSession session = request.getSession();
			//if(uri.endsWith("addbooks")) {
				//String selectedbooks[]=request.getParameterValues("books");
				model.put("bikes", selectedbikes);
			//Map<String,Object> attributes = new HashMap<String,Object>();
			//attributes.put("Session",session);
			return viewname;
		}

}
