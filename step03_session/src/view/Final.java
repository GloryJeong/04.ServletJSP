package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Final
 */
@WebServlet("/final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Final() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("save servlet");
		// myId, myAge, myName 으로 지정되어 있는 모든 쿠키 출력?
		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length;i++) {
			if("myName".equals(cookies[i].getName())) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName());
		}
		// myName만 삭제?
		
	}

}
