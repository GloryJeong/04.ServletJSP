package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.model.CustomerDAO;
import reservation.model.CustomerDTO;


/**
 * Servlet implementation class controller
 */
@WebServlet("/customer")
public class customerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public customerController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("command"));
		
		String command = null;
		command =request.getParameter("command");
		if(command == null) {
			response.sendRedirect("index.jsp");
		}else if("list".equals(command)) {
			customerList(request,response);
		}else if("delete".equals(command)) {
			customerDelete(request,response);
		}else if("add".equals(command)) {
			customerAdd(request,response);
		}
		
		
		
		
//		String customerId =request.getParameter("id");
//		
//		try {
//			CustomerDTO customer = CustomerDAO.selectCustomer(customerId);
//			if(customer != null) {
//				System.out.println(customer);
//				request.setAttribute("customer",customer);
//			}else {
//				System.out.println("이름이 없음");
//				request.setAttribute("customer","이름이 없음");
//			}
//			request.getRequestDispatcher("customer.jsp").forward(request, response);
//		} catch (SQLException e) {
//			response.sendRedirect("failView.jsp");
//		}
		
	}
	private void customerAdd(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		
	}

	private void customerDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String customerId =request.getParameter("customerId");
		String command = request.getParameter("command");
		
		try {
			CustomerDAO.deleteCustomer(customerId);
		}catch(SQLException e){
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		response.sendRedirect("customer");
		
	}

	private void customerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CustomerDTO> customerList = null;
		try {
			customerList = CustomerDAO.allCustomers();
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		request.setAttribute("customerList", customerList);
		request.getRequestDispatcher("customer.jsp").forward(request, response);
	}

}
