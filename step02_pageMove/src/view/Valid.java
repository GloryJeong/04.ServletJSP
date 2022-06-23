package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vaild
 */
@WebServlet("/valid")
public class Valid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valid() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><head>Login Test</head>");
		out.println("<body><h2>Result</h2>");
		out.println("<div> id : "+request.getParameter("uname")+"</div>");
		out.println("<div> pw : "+request.getParameter("psw")+"</div>");
		out.println("</body></html>");
	}

}
