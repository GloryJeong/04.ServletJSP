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
		
		// �޼ҵ� ����
		
		/* step01 : ������ ȹ��
		 * empno ��� -> ename ����� �̸��� ��ȯ�������� �մϴ�!
		 * String ename = EmpDAO.getName(empno);
		 * 
		 * step02 : (forward vs redirect)
		 * ename �ִٰ� �Ѵٸ�? -> view.jsp �̸����� ���� (?)
		 * ename ���ٰ� �Ѵٸ�? -> view.jsp "����� �̸��� �����ϴ�" ���ڿ��� ���� (?)
		 * ���࿡ SQLException�� �߻��Ѵٸ�? -> failView.jsp�� �̵� (?)
		 * 
		*/
		HttpSession session = request.getSession();
//		try {
//			String ename = EmpDAO.getName(empno);
//			if(ename != null) {
//				System.out.println(ename);
//				session.setAttribute("ename",ename);
//			}else {
//				System.out.println("�̸��� ����");
//				session.setAttribute("ename","�̸��� ����");
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
				System.out.println("�̸��� ����");
				request.setAttribute("ename","�̸��� ����");
			}
			request.getRequestDispatcher("view.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("failView.jsp");
		}
		
		
	}

}
