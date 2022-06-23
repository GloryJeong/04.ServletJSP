package reservation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class RoomDAO {
	//��� �� �����ֱ�
	
	public static ArrayList<RoomDTO> allRoom() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RoomDTO> roomlist = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from room");
			rset = pstmt.executeQuery();
			
			roomlist = new ArrayList<RoomDTO>();
			while (rset.next()) {
				roomlist.add(new RoomDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4)));
			}
		}finally {
			DBUtil.close( rset, pstmt,con);
		}
		return roomlist;
	}

	
	// �� ã�� selectRoom int roomId
	public static RoomDTO selectRoom(int roomId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RoomDTO slroom = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from room where room_id=?");
			pstmt.setInt(1, roomId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				slroom = new RoomDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4));
			}
		}finally {
			DBUtil.close( rset, pstmt,con);
		}
		
		return slroom;
	}	
	
	//�� �߰��ϱ�
	public static boolean addRoom(RoomDTO newRoom) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con= DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into room(room_id,max_capacity,price,region) values(?, ?, ?, ?)");
			pstmt.setInt(1, newRoom.getRoomId());
			pstmt.setInt(2, newRoom.getMax_Capacity());
			pstmt.setString(3, newRoom.getPrice());
			pstmt.setString(4, newRoom.getRegion());
			int result = pstmt.executeUpdate();
			if (result==1) {
				return true;
			}
			
		} finally {
			DBUtil.close(pstmt, con);
		}
		return false;
	}
	
	
	//roomId�� price �����ϱ�
	public static boolean updateRoom(int roomId, String price) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update room set price = ? where room_id=?");
			pstmt.setString(1, price);
			pstmt.setInt(2, roomId);
			

		
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
		}
		}finally {
			DBUtil.close(pstmt, con);
		}
		return false;
	}
			
		//�� ����
	public static boolean deleteRoom(int roomId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from room where room_id=?");
			pstmt.setInt(1, roomId);
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(pstmt, con);
		}
		return false;
		}

}






