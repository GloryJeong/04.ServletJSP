package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }
    // ������ id���� �ִٸ� -> ��Ű ���� 365��
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("uname");
		
		HttpSession session1 = request.getSession();
		System.out.println("IdCheck - "+session1.getId());
		session1.setAttribute("lecture", "web Study");
		response.sendRedirect("save");
		
		
		
		
		
		// ��Ű
//		System.out.println(id);
//		if(id != null && id .length() !=0) {
//			// ��Ű ����
//			Cookie cookie1 = new Cookie("myID",id);
//			Cookie cookie2 = new Cookie("myAge","26");
//			
//			// ��Ű ���� �ð� ����
//			// 60*60*24*365 1�� �ð�
//			cookie1.setMaxAge(60*60*24*365);
//			cookie2.setMaxAge(60*60*24*365);
//			
//			//Client���� ���� �� ����
//			response.addCookie(cookie1);
//			response.addCookie(cookie2);
//			
//			response.sendRedirect("save");			
//		}
	}

}
