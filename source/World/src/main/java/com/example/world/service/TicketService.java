package com.example.world.service;



import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.world.dao.ITicketDao;
import com.example.world.dto.Cart2VO;
import com.example.world.dto.TicketVO;

@Service
public class TicketService {
	@Autowired
	ITicketDao tdao;

	public void insertTicket(TicketVO tvo) {
		tdao.insertTicket(tvo);
		
	}

	public void deleteCart(int cseq) {
		tdao.deleteCart(cseq);
		
	}

	public void orderCart(int cseq) {
		tdao.orderCart(cseq);
		
	}


	public HashMap<String, Object> orderCheck(int cseq) {
		HashMap<String, Object> result2 =new HashMap<String, Object>();
		int visitnum=0;
		int p1=0;
		int p2=0;
		String visitDate= tdao.getvisitDate(cseq);
		
		System.out.println(visitDate);
		String result = visitDate.substring(0, 10);
		System.out.println(result);
		System.out.println();
		
		ArrayList<Cart2VO> visitList = tdao.getvisitList(result);
		for(int i=0; i<visitList.size(); i++ ) {
			
			p1 += visitList.get(i).getP1();
			p2 += visitList.get(i).getP2();
		}
		visitnum=p1+p2;
		
	
		System.out.println(visitnum + "명");
		System.out.println();
	
		result2.put("visitDate" , result);
		result2.put("visitnum", visitnum);
		
		return result2;
		
	}
	
	
	public void returnOrder(int cseq) {
		
		tdao.returnOrder(cseq);
	}

	public HashMap<String, Object> fastCheck(int cseq) {
		HashMap<String, Object> result =new HashMap<String, Object>();
		int kind=0;
		String visitDate= tdao.getvisitDate(cseq); //선택한 번호로 날짜 조회
		String result2 = visitDate.substring(0, 10);
		Cart2VO cvo = tdao.fastCheck(result2);// 위에서 조회한 날짜로 패스트티켓 조회
		Cart2VO cvo2 = tdao.kindCheck(cseq);// 선택한 번호의 티켓 종류 조회
		if(cvo!=null) {
			if(cvo.getKind()==cvo2.getKind()) { // 날짜로 조회한 것과 선택한 번호의 티켓 종류가 같은지 확인
				kind=1;  
			}
		}
		System.out.println(kind);
		result.put("cvo" , cvo);
		result.put("kind", kind);
		
		return result;
	}
	
	/*
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public int ticketBuy(int error) {
		if(error==1) {
			throw new RuntimeException();
		}
		
		
		return error;
	}
	
	*/

	/*
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public int ticketBuy(String[] cseqArr) {
		int cnt=10;
		int result=0;
		 for (String cseq : cseqArr) {
		        orderCart(Integer.parseInt(cseq));
		        int visitNum = orderCheck(Integer.parseInt(cseq));
		        if (visitNum > cnt) {
		            System.out.println("선택하신 날짜의 인원이 마감되었습니다 다른 방문일을 선택해 주세요");
		            System.out.println();
		            System.out.println();
		            throw new RuntimeException("선택하신 날짜의 인원이 마감되었습니다");
		        }
		    }
		
		return result;
	}
	*/
	
	
}

