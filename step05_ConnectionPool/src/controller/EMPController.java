package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmpDAO;

@WebServlet("/emp")
public class EMPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EMPController() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empno =Integer.parseInt(request.getParameter("empno"));
		
		// 메소드 정의
		
		/* step01 : 데이터 획득
		 * empno 사번 -> ename 사원의 이름을 반환받으려고 합니다!
		 * String ename = EmpDAO.getName(empno);
		 * 
		 * step02 : (forward vs redirect)
		 * ename 있다고 한다면? -> view.jsp 이름값을 전달 (?)
		 * ename 없다고 한다면? -> view.jsp "사원의 이름이 없습니다" 문자열을 전달 (?)
		 * 만약에 SQLException이 발생한다면? -> failView.jsp로 이동 (?)
		 * 
		*/
		HttpSession session = request.getSession();
//		try {
//			String ename = EmpDAO.getName(empno);
//			if(ename != null) {
//				System.out.println(ename);
//				session.setAttribute("ename",ename);
//			}else {
//				System.out.println("이름이 없음");
//				session.setAttribute("ename","이름이 없음");
//			}
//			request.getRequestDispatcher("view.jsp").forward(request, response);
//		} catch (SQLException e) {
//			response.sendRedirect("failView.jsp");
//		}
		try {
			String ename = EmpDAO.getName(empno);
			if(ename != null) {
				System.out.println(ename);
				request.setAttribute("ename",ename);
			}else {
				System.out.println("이름이 없음");
				request.setAttribute("ename","이름이 없음");
			}
			request.getRequestDispatcher("view.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("failView.jsp");
		}
		
		
	}

}
