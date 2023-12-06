package com.example.world.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.world.dao.IQnaDao;
import com.example.world.dto.Paging;
import com.example.world.dto.QnaVO;


@Service
public class QnaService {
	@Autowired
	IQnaDao qdao;

	public HashMap<String, Object> qnaList(HttpServletRequest request) {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
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
		int count = qdao.getAllCount( "Lqna", "title", key );
		paging.setTotalCount(count);
		paging.paging();
		
		List<QnaVO> list = qdao.listQna( paging , key );
		result.put("qnaList" , list);
		result.put("paging", paging);
		result.put("key", key);
		
		return result;
	}

	public QnaVO getQna(int lqseq) {
		
		return qdao.getQna(lqseq);
	}

	public void insertQna( QnaVO qnavo) {
		qdao.insertQna(qnavo);
		
	}

}
