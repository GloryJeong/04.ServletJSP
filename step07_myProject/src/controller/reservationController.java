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
import reservation.model.ReservationDAO;
import reservation.model.ReservationDTO;

/**
 * Servlet implementation class reservationController
 */
@WebServlet("/reservation")
public class reservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reservationController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command;
		command =request.getParameter("command");
		if(command == null || "list".equals(command)) {
			reservationList(request,response);
		}else if("delete".equals(command)) {
			reservationDelete(request,response);
		}else if("add".equals(command)) {
			reservationAdd(request,response);
		}else if("select".equals(command)) {
			reservationSelect(request,response);
		}else if("update".equals(command)) {
			reservationUpdate(request,response);
		}
	}

	private void reservationUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private void reservationSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private void reservationAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private void reservationDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private void reservationList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ReservationDTO> reservationList =null;
		try {
			reservationList = ReservationDAO.allReservation();
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		request.setAttribute("reservationList", reservationList);
		request.getRequestDispatcher("./reservation/reservation.jsp").forward(request, response);
	}

}
