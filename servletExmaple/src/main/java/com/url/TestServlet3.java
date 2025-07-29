package com.url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("*.do")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>TestServelet3 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		
		out.println("<body bgcolor='skyblue'>");
		out.println("<h3>TestServlet3입니다.</h3>");
		out.println("<div><strong>컨텍스트명 : "+context + "</strong></div>");
		out.println("<div><strong>전체 경로 : "+ url + "</strong></div>");
		out.println("<div><strong>메핑명 : "+mapping + "</strong></div>");
		out.println("<div><strong>URI : "+uri + "</strong></div>");
		out.println("</body>");
		out.println("</html>");
	}

}
