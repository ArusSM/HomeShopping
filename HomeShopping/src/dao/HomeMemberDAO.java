package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtil;
import vo.MemberMoneyVO;
import vo.MemberVO;

public class HomeMemberDAO {
	public ArrayList<MemberVO> getMemberList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select custno, custname, phone, address, joindate, decode(grade, 'A','VIP','B','일반','C','직원') grade, city from member_tbl_02";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<MemberMoneyVO> getMoneyList() {
		ArrayList<MemberMoneyVO> list = new ArrayList<MemberMoneyVO>();
		
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select A.custno, A.custname, decode(A.grade, 'A','VIP','B','일반','C','직원') grade, sum(B.price) price \r\n"
				+ "from member_tbl_02 A, money_tbl_02 B \r\n"
				+ "where A.custno = B.custno \r\n"
				+ "group by A.custno, A.custname, A.grade \r\n"
				+ "order by price desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberMoneyVO vo = new MemberMoneyVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setGrade(rs.getString("grade"));
				vo.setPrice(rs.getInt("price"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	public int insertMember(MemberVO member) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		/*
	custno number(6) NOT NULL,
	custname varchar2(20),
	phone varchar2(13),
	address varchar2(60),
	joindate date,
	grade char(1),
	city char(2),
		 */
	
		conn = JDBCUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, member.getCustno());
			pstmt.setString(2, member.getCustname());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setDate(5, member.getJoindate());
			pstmt.setString(6, member.getGrade());
			pstmt.setString(7, member.getCity());
			n = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return n;
	}
	// --
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
	public MemberVO getMemberData(int custno) {
		MemberVO vo = null;
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02 where custno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	public int updateMember(MemberVO vo) {
		/*
	custno number(6) NOT NULL,
	custname varchar2(20),
	phone varchar2(13),
	address varchar2(60),
	joindate date,
	grade char(1),
	city char(2),
		 */
		int n = 0;
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = conn.prepareStatement("update member_tbl_02 set custname=?, phone=?, address=?, grade=?, city=? where custno=?");
			pstmt.setString(1, vo.getCustname());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getGrade());
			pstmt.setString(5, vo.getCity());
			pstmt.setInt(6, vo.getCustno());
			n = pstmt.executeUpdate();
			
			if(n > 0) {
				System.out.println("업데이트 정상 실행");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return n;
	}
}
