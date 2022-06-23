package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class EmpDAO {

	public static String getName(int empno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select ename from emp where empno = ?");
			pstmt.setInt(1,empno);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				return rset.getString(1);
			}
		} finally {
			DBUtil.close(rset,pstmt, conn);
		}
		return null;
	}
	
}
