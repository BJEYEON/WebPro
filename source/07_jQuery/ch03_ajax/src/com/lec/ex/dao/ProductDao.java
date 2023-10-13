package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDao {
	private DataSource ds;
	//싱글톤
	private ProductDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage() + " - 커넥션 풀 ");
		}
	}
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstace() {
		return instance;
	}
	//재고량return
	public int getProductStock(String pname) {
		int pStock = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT PSTOCK FROM PRODUCT WHERE PNAME=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pStock = rs.getInt("pStock");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " - SQL");
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return pStock;
	}
}
