package step02;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print")
public class ValuePrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void valueSelect(Object event) {
    	System.out.println(event);
    }
    public ValuePrint() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	System.out.println(request.getQueryString());
    	System.out.println(URLDecoder.decode(request.getQueryString(),"UTF-8"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ServletInputStream  input = request.getInputStream();
		System.out.println(input);
		
		int length = request.getContentLength();
		byte[] data = new byte[length];
		input.readLine(data, 0, length);
		String str = new String(data);
		System.out.println(str);
		System.out.println(URLDecoder.decode(str,"UTF-8"));
		
		
		
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h2>Value Print!!</h2>");
//		String[] test = request.getParameterValues("like");
//		for(String value : test) {
//			out.println("<div>"+value+"</div>");
//		}
//		out.println("</body>");		
//		out.println("</html>");
	}

}
