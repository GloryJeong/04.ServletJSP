package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		try {
			String ename = EmpDAO.getName(empno);
			if(ename != null) {
				System.out.println(ename);
			}else {
				System.out.println("�̸��� ����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
