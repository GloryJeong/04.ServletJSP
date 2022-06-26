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
		String command;
		command =request.getParameter("command");
		if(command == null || "list".equals(command)) {
			customerList(request,response);
		}else if("delete".equals(command)) {
			customerDelete(request,response);
		}else if("add".equals(command)) {
			customerAdd(request,response);
		}else if("select".equals(command)) {
			customerSelect(request,response);
		}else if("update".equals(command)) {
			customerUpdate(request,response);
		}
		
		
		
		
		
	}
	private void customerUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		int headCount = Integer.parseInt(request.getParameter("headCount"));
		String phoneNum = request.getParameter("pNumber");
		if(customerId != null && headCount != 0 && phoneNum != null) {
			try {
				CustomerDAO.updateCustomer(customerId, headCount, phoneNum);
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendRedirect("failView.jsp");
			}
			response.sendRedirect("customer");
		}else {
			response.sendRedirect("failView.jsp");
		}
	}

	private void customerSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerId =request.getParameter("selectId");
		ArrayList<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
//		customerList = null;
		
		try {
			CustomerDTO customer = CustomerDAO.selectCustomer(customerId);
			if(customer != null) {
				customerList.add(customer);
			}else {
				System.out.println("해당 고객 없음");
				request.setAttribute("customer","이름이 없음");
			}
			request.setAttribute("customerList", customerList);
			request.getRequestDispatcher("/customer/customer.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("failView.jsp");
		}
	}

	private void customerAdd(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		String customerId = request.getParameter("ctmId");
		int headCount = Integer.parseInt(request.getParameter("headCount"));
		String name = request.getParameter("name");
		String pNumber = request.getParameter("pNumber");
		
		try {
			CustomerDAO.addCustomer(new CustomerDTO(customerId,headCount,name,pNumber));
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		response.sendRedirect("customer");
		
	}

	private void customerDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String customerId =request.getParameter("customerId");
		
		try {
			CustomerDAO.deleteCustomer(customerId);
		}catch(SQLException e){
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		response.sendRedirect("customer");
		
	}

	private void customerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CustomerDTO> customerList =null;
		try {
			customerList = CustomerDAO.allCustomers();
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		request.setAttribute("customerList", customerList);
		request.getRequestDispatcher("./customer/customer.jsp").forward(request, response);
	}

}
