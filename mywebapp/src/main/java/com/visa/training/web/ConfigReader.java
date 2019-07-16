package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigReader extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig config = getServletConfig();
		String res = config.getInitParameter("user");
		
		ServletContext app = getServletContext();
		
		String con = app.getInitParameter("company");
		PrintWriter out=resp.getWriter();
		out.println("user is:"+ res);
		out.println("comp is:"+ con);
		
	}

}
