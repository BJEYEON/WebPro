package com.example.world.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.world.dao.IMemberDao;
import com.example.world.dto.Cart2VO;
import com.example.world.dto.MemberVO;
import com.example.world.dto.Paging;

@Service
public class MemberService {

	@Autowired
	IMemberDao mdao;

	public MemberVO getMember(String id) {
		return mdao.getMember(id);
	}
	
	public void joinKakao(MemberVO mvo) {
		mdao.joinKakao( mvo );	
		}

	public void insertMember(MemberVO membervo) {
		mdao.insertMember(membervo);
		}

	public void updateMember( MemberVO membervo) {
		mdao.updateMember( membervo );
		}

	public void withdrawalMember(String id) {
		mdao.withDrawalMember(id);		
		}

	public HashMap<String, Object> getCartList(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String id= mvo.getId();
		if( request.getParameter("first")!=null ) {
			session.removeAttribute("page");
			session.removeAttribute("key");
		}
		
		int page = 1;
		if( request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		} else if( session.getAttribute("page")!= null ) {
			page = (int) session.getAttribute("page");
		} else {
			page = 1;
			session.removeAttribute("page");
		}
		
		String key = "";
		if( request.getParameter("key") != null ) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		} else if( session.getAttribute("key")!= null ) {
			key = (String)session.getAttribute("key");
		} else {
			session.removeAttribute("key");
			key = "";
		} 
		
		Paging paging = new Paging();
		paging.setPage(page);
		
		int count = mdao.getAllCount( "cart2", "cseq", key );
		paging.setTotalCount(count);
		paging.paging();
		
		List<Cart2VO> cartList = mdao.listCart( paging , key,id );
		result.put("cartList" , cartList);
		result.put("paging", paging);
		result.put("key", key);
		
		return result;
  }

    public MemberVO selectId(String name, String phone) {
		
		return mdao.selectId(name,phone);
	}

	public MemberVO selectPwd(String id, String name, String phone) {
		
		return mdao.selectPwd(id,name,phone);
	}


	public HashMap<String, Object> getorderList(HttpServletRequest request) {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String id= mvo.getId();
		if( request.getParameter("first")!=null ) {
			session.removeAttribute("page");
			session.removeAttribute("key");
		}
		
		int page = 1;
		if( request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		} else if( session.getAttribute("page")!= null ) {
			page = (int) session.getAttribute("page");
		} else {
			page = 1;
			session.removeAttribute("page");
		}
		
		
		Paging paging = new Paging();
		paging.setPage(page);
		
		int count = mdao.getAllCount2( "cart2");
		paging.setTotalCount(count);
		paging.paging();
		
		int result2= 1;
		List<Cart2VO> orderList = mdao.listOrder( paging, id ,result2 );
		result.put("orderList" , orderList);
		result.put("paging", paging);
		
		
		return result;
		
	}

	public void resetNewPwd(MemberVO membervo) {
		
		mdao.resetNewPwd(membervo);
		
	}
}
