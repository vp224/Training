package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingKart
 */
@WebServlet({ "/addbooks", "/addcars", "/addbikes" })
public class ShoppingKart extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		if(uri.endsWith("addbooks")) {
			String selectedbooks[]=request.getParameterValues("books");
			session.setAttribute("selectedbooks", selectedbooks);
			request.getRequestDispatcher("cars.html").forward(request,response);
		
		}
		if(uri.endsWith("addcars")) {
			String selectedcars[]=request.getParameterValues("cars");
			session.setAttribute("selectedcars", selectedcars);
			request.getRequestDispatcher("bikes.html").forward(request,response);
		
		}
		if(uri.endsWith("addbikes")) {
			String selectedbikes[]=request.getParameterValues("bikes");
			String selectedbooks[]=(String[])session.getAttribute("selectedbooks");
			String selectedcars[]=(String[])session.getAttribute("selectedcars");
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h4>selected books</h4>");
			out.println("<ul>");
			Stream.of(selectedbooks).map(s->"<li>"+s+"</li>").forEach(out::println);
			out.println("<ul>");
			
			out.println("<html><body>");
			out.println("<h4>selected cars</h4>");
			out.println("<ul>");
			Stream.of(selectedcars).map(s->"<li>"+s+"</li>").forEach(out::println);
			out.println("<ul>");
			
			out.println("<html><body>");
			out.println("<h4>selected bikes</h4>");
			out.println("<ul>");
			Stream.of(selectedbikes).map(s->"<li>"+s+"</li>").forEach(out::println);
			out.println("<ul>");
			
			session.invalidate();
			//request.getRequestDispatcher("cars.html").forward(request,response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
