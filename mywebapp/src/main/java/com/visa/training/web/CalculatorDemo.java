package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.jdbc.Product;
import com.visa.training.jdbc.ProductDAO;

/**
 * Servlet implementation class CalculatorDemo
 */
@WebServlet("/product")
public class CalculatorDemo extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String s1 = request.getParameter("n1");
		//String s2 = request.getParameter("n2");
		//String s3 = request.getParameter("op");
		
		//double s11 = Double.parseDouble(s1);
		//double s22 = Double.parseDouble(s2);
		//double s33 = Double.parseDouble(s3);
//		double res =0;
//		if (s3.equals( "+"))
//		{
//			res = s11+s22;
//		}
//		if (s3.equals( "-")) res =s11-s22;
//		if(s3.equals( "*")) res = s11 *s22;
//		if (s3.equals( "/")) res = s11/s22;
		
		//PrintWriter out = response.getWriter();
		//out.println(s11+" "+s3+" "+s22+" ="+res);
		
		
		//request.setAttribute("result", res);
		//request.getRequestDispatcher("calcresult_el.jsp").forward(request, response);
		
		
		String s1 = request.getParameter("p_name");
		String s2 = request.getParameter("p_price");
		String s3 = request.getParameter("p_qoh");
//		
		double price = Double.parseDouble(s2);
		int qoh = Integer.parseInt(s3);
		Product p = new Product(s1,(float)price,qoh);
		ProductDAO n = new ProductDAO();
		int genId=0;
		try {
			genId = n.save(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(genId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
