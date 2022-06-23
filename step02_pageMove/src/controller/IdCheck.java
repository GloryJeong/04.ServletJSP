package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdCheck() {}
    // id값이 busan이라고 한다면 -> /vaild 매핑 되어 있는 servlet 화면 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("uname");
		if("busan".equals(id)) {
			// vaild 매핑 되어 있는 servlet 화면 이동
			
			//
	        request.getRequestDispatcher("valid").forward(request, response);
			
			
		}else {
			response.sendRedirect("invalid");
//			request.getRequestDispatcher("invalid").forward(request, response);
		}
	}

}
