package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCUtil;
import vo.MemberVO;

public class HomeMemberDAO {
	public int insertMember(MemberVO member) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		/*
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
		 */
		conn = JDBCUtil.getConnection();
		try {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int getMaxCustNo() {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = JDBCUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select max(custno)+1 maxno from member_tbl_02");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				n = rs.getInt("maxno");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return n;
	}
}
