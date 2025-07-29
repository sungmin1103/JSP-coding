package com.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookInput
 */
@WebServlet("/firstBook")
public class FirstBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("bookTitle","어서 오세요, 휴남동 서점입니다.");
		request.setAttribute("bookType", "소설");
		request.setAttribute("plot", "서점을 통한 사람들의 이야기");
		request.setAttribute("author", "황보름");
		request.setAttribute("price", 13500);
		
		RequestDispatcher book = request.getRequestDispatcher("secondBook");
	    book.forward(request, response);
	}

}
