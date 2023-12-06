package com.example.world.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.world.dao.INoticeDao;
import com.example.world.dto.NoticeVO;
import com.example.world.dto.Paging;

@Service
public class NoticeService {
	
	@Autowired
	INoticeDao ndao;

	public HashMap<String, Object> getNotice(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		if(request.getParameter("first")!=null) {
			session.removeAttribute("page");
			session.removeAttribute("key");
		}
		
		int page=1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		}else if(session.getAttribute("page")!=null) {
			page = (int) session.getAttribute("page");
		}else {
			page=1;
			session.removeAttribute("page");
		}
		
		String key="";
		if(request.getParameter("key")!=null) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		}else if(session.getAttribute("key")!=null) {
			key = (String)session.getAttribute("key");
		}else {
			session.removeAttribute("key");
			key="";
		}
		
		Paging paging = new Paging();
		paging.setPage(page);
		
		int count = ndao.getAllCount("notice", "title", key);
		paging.setTotalCount(count);
		paging.paging();
		
		List<NoticeVO> noticeList = ndao.listNotice(paging, key);
		result.put("noticeList", noticeList);
		result.put("paging", paging);
		result.put("key", key);
		
		return result;
	}

	public NoticeVO viewNotice(int nseq) {
		return ndao.viewNotice(nseq);
	}

	public NoticeVO getNotice(int nseq) {
		return ndao.getNotice(nseq);
	}
}
