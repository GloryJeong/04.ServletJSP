package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.model.RoomDAO;
import reservation.model.RoomDTO;


/**
 * Servlet implementation class roomController
 */
@WebServlet("/room")
public class roomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public roomController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command;
		command =request.getParameter("command");
		if(command == null || "list".equals(command)) {
			roomList(request,response);
		}else if("delete".equals(command)) {
			roomDelete(request,response);
		}else if("add".equals(command)) {
			roomAdd(request,response);
		}else if("select".equals(command)) {
			roomSelect(request,response);
		}else if("update".equals(command)) {
			roomUpdate(request,response);
		}
	}

	private void roomUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		String price = request.getParameter("price");
		if(roomId != 0 && price != null) {
			try {
				RoomDAO.updateRoom(roomId,price);
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendRedirect("failView.jsp");
			}
			response.sendRedirect("room");
		}else {
			System.out.println("111");
			response.sendRedirect("failView.jsp");
		}
	}

	private void roomSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomId =Integer.parseInt(request.getParameter("selectId"));
		ArrayList<RoomDTO> roomList = new ArrayList<RoomDTO>();
		
		try {
			RoomDTO room = RoomDAO.selectRoom(roomId);
			if(room != null) {
				roomList.add(room);
			}else {
				System.out.println("해당 고객 없음");
				request.setAttribute("room","이름이 없음");
			}
			request.setAttribute("roomList", roomList);
			request.getRequestDispatcher("./room/room.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("failView.jsp");
		}
	}

	private void roomAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		int maxCapacity = Integer.parseInt(request.getParameter("maxCapacity"));
		String price = request.getParameter("price");
		String region = request.getParameter("region");
		
		try {
			RoomDAO.addRoom(new RoomDTO(roomId,maxCapacity,price,region));
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		response.sendRedirect("room");
	}

	private void roomDelete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int roomId =Integer.parseInt(request.getParameter("roomId"));
		
		try {
			RoomDAO.deleteRoom(roomId);
		}catch(SQLException e){
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		response.sendRedirect("room");
		
	}

	private void roomList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<RoomDTO> roomList =null;
		try {
			roomList = RoomDAO.allRoom();
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		}
		request.setAttribute("roomList", roomList);
		request.getRequestDispatcher("./room/room.jsp").forward(request, response);
	}

}
