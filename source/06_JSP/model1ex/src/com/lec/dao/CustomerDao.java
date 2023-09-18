package com.lec.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDao {
	public static final int CUSTOMER_EXISTENT = 0; //아이디중복체크시 존재하는ID일경우RETURN값
	public static final int CUSTOMER_NONEXISTENT = 1; //사용가능한 ID일 경우RETURN값
	public static final int LOGIN_SUCCESS = 1; //로그인 성공시 RETURN값
	public static final int LOGIN_FAIL_PW = 0; //로그인 시 PW오류일때 RETURN값
	public static final int LOGIN_FAIL_ID = -1; //로그인 시 ID오류일때 RETURN값
	public static final int SUCCESS = 1; //회원가입, 회원정보 수정시 성공할때RETURN값
	public static final int FAIL = 0; //회원가입, 회원정보 수정시 실패할때RETURN값
	
	//connection객체를return
	private Connection getconnConnection() throws SQLException{
		return null;
		
	}
}
