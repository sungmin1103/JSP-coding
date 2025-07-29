package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet2
 */
@WebServlet("/calcServlet2")
public class CalcServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String num1Str = request.getParameter("num1");
		String num2Str = request.getParameter("num2");
		
		int num1 = Integer.parseInt(num1Str);
		int num2 = Integer.parseInt(num2Str);
		String op = request.getParameter("operator");
		
		Calc calc = new Calc(num1, num2, op);
		int result = calc.getResult();
		
		out.print(result);
		out.close();
	}

}
