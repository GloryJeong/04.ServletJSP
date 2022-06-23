package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionFinal
 */
@WebServlet("/sessionFinal")
public class SessionFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionFinal() {
        super();
    }
    
    // SessionFinal 로그아웃 버튼 클릭 했을 때 -> 현재의 Servlet에서 세션 무효화
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		out.println(session.getAttribute("lecture"));
		out.println("<button onClick='location.href=\"invalid\"'> 로그아웃 </button>");
	}

}
