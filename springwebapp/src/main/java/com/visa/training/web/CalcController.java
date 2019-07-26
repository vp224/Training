package com.visa.training.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//String s1 = request.getParameter("n1");
		//String s2 = request.getParameter("n2");
		//String s3 = request.getParameter("op");
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
		
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
		
		
@Controller
public class CalcController {
	@RequestMapping("/calculate")
	public ModelAndView calc(@RequestParam("n1")String n1 ,@RequestParam("n2") String n2 , @RequestParam("op") String op ) {
		double n11 = Double.parseDouble(n1);
		double n22 = Double.parseDouble(n2);
		String viewName = "calcview";
		double res =0;
		if (op.equals( "+"))
		{
			res = n11+n22;
		}
		if (op.equals( "-")) res =n11-n22;
		if(op.equals( "*")) res = n11 *n22;
		if (op.equals( "/")) res = n11/n22;
		
		Map<String,Object> attributes = new HashMap<String,Object>();
		attributes.put("result", res);
		return new ModelAndView(viewName,attributes);
	}
	

}
