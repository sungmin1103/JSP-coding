package com.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookOutput
 */
@WebServlet("/secondBook")
public class SecondBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String bookTitle = (String)request.getAttribute("bookTitle");
		String bookType = (String)request.getAttribute("bookType");
		String plot = (String)request.getAttribute("plot");
		String author = (String)request.getAttribute("author");
		int price = (int)request.getAttribute("price");
		
		 out.println("<!DOCTYPE html><html>");
	     out.println("<head><meta charset='UTF-8' />");
	     out.println("<title>dispatcher 예제</title>");
	     out.println("<link rel='icon' href='data:,'></head>");
	     out.println("<body>");
	     out.println("<div> 책의 제목 : " + bookTitle + "</div>");
	     out.println("<div> 책의 종류 : " + bookType + "</div>");
	     out.println("<div> 줄거리 : " + plot + "</div>");
	     out.println("<div> 책의 저자 : " + author + "</div>");
	     out.println("<div> 가격 : " + price + "</div>");
	     
	     out.println("<div> 평온한 일상을 할떄 같이 즐기고픈 책입니다.</div>");
	     out.println("</body></html>");
	}

}
