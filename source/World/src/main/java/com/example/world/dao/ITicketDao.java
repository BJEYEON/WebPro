package com.example.world.dao;



import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.world.dto.Cart2VO;
import com.example.world.dto.TicketVO;

@Mapper
public interface ITicketDao {

	void insertTicket(TicketVO tvo);

	void deleteCart(int cseq);

	void orderCart(int cseq);

	ArrayList<Cart2VO> getvisitList(String visitDate);

	String getvisitDate(int cseq);

	void returnOrder(int cseq);

	Cart2VO fastCheck(String result);

	Cart2VO kindCheck(int cseq);


}
