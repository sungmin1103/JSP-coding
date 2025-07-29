package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet2
 */
@WebServlet(
		name = "firstServlet2", 
		urlPatterns = { 
				"/first2", 
				"/first3"
		})
public class FirstServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset= 'UTF-8' />");
		out.println("<title>JSP 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body><h1>Hello Servlet ~~!</h1></bodt>");
		out.println("</html>");
		
		out.close();
	}

}
