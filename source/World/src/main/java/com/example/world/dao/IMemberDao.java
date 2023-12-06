package com.example.world.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;

import com.example.world.dto.Cart2VO;
import com.example.world.dto.MemberVO;
import com.example.world.dto.Paging;

@Mapper
public interface IMemberDao {

	MemberVO getMember(String id);
	void joinKakao(MemberVO mvo);
	void insertMember(MemberVO membervo);
	void updateMember(MemberVO membervo);
	void withDrawalMember(String id);
	HashMap<String, Object> getCartList(HttpServletRequest request);
	int getAllCount(String string, String string2, String key);
	List<Cart2VO> listCart(Paging paging, String key, String id);
	MemberVO selectId(String name, String phone);
	MemberVO selectPwd(String id, String name, String phone);
	
	
	List<Cart2VO> listOrder(Paging paging, String id , int result);
	int getAllCount2(String string);
	void resetNewPwd(MemberVO membervo);

}
