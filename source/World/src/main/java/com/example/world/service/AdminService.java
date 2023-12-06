package com.example.world.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.world.dao.IAdminDao;
import com.example.world.dto.AdminVo;
import com.example.world.dto.AttractionVO;
import com.example.world.dto.BannerVO;
import com.example.world.dto.Cart2VO;
import com.example.world.dto.NoticeVO;
import com.example.world.dto.Paging;
import com.example.world.dto.QnaVO;

@Service
public class AdminService {

	@Autowired
	IAdminDao adao;

	public int workerCheck(String workId, String workPwd, String workName) {
		System.out.println("id : " + workId);
		String pwd = adao.getPwd( workId );
		String name = adao.getName( workId );
		System.out.println("pwd : " + pwd);
		System.out.println("name : " + name);
		int result=0;
		
		if(pwd == null) result = -1;   // 아이디가 없습니다
		else if( workPwd.equals(pwd)) result =  1;   // 정상 로그인
		else if( !workPwd.equals(pwd)) result =  0;  // 비번이 틀립니다
		
		return result;
	}

	//공지사항
	public HashMap<String, Object> getNoticeList(HttpServletRequest request) {
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
		
		int count = adao.getAllCount("notice", "title", key);
		paging.setTotalCount(count);
		paging.paging();
		
		List<AdminVo> noticeList = adao.listNotice(paging, key);
		result.put("noticeList", noticeList);
		result.put("paging", paging);
		result.put("key", key);
		
		return result;
	}

	public void updateNotice(NoticeVO noticevo) {
		adao.updateNotice(noticevo);
	}

	// -------------------------------- 배너 ------------------------
	public List<BannerVO> getBannerList() {
		return adao.getBannerList();
	}
	public void insertBanner(BannerVO bannervo) {
		adao.insertBanner( bannervo );		
	}
	public void updateSeq(int changeval, String useyn, int bseq) {
		adao.updateSeq( changeval, useyn, bseq );
	}
	public void deleteBanner(int bseq) {
		adao.deleteBanner(bseq);
	}


	// --------------------------------- Q&A ---------------------------------
	public HashMap<String, Object> getQnaList(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if ( request.getParameter("first") != null) {
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
		int count = adao.getAllCount( "lqna ","title", key );
		paging.setTotalCount(count);
		paging.paging();
		List<QnaVO> list = adao.listQna( paging , key );
		result.put("qnaList" , list);
		result.put("paging", paging);
		result.put("key", key);	
		return result;
	}
	public void updateQna(int lqseq, String reply) {
		adao.updateQna( lqseq, reply );
		
	}

	// ----------------------------멤버----------------------------------
	public HashMap<String, Object> getMeberList(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		if ( request.getParameter("first") != null) {
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
		
		int count = adao.getAllCount( "lmember ","name", key );
		paging.setTotalCount(count);
		paging.paging();
		
		List<QnaVO> list = adao.listMember( paging , key );
		result.put("memberList" , list);
		result.put("paging", paging);
		result.put("key", key);
		
		return result;
	}
	
	// ---------------------------------- 어트랙션 -------------------------------------
	public HashMap<String, Object> getAttractionList(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		if ( request.getParameter("first") != null) {
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
		
		int count = adao.getAllCount( "attraction ","atname", key );
		paging.setTotalCount(count);
		paging.paging();
		
		List<QnaVO> list = adao.listAttraction( paging , key );
		result.put("attractionList" , list);
		result.put("paging", paging);
		result.put("key", key);
		
		return result;
	}
	public void insertat( AttractionVO attractionvo) {
		adao.insertat( attractionvo );
	}
	public void updateat( AttractionVO attractionvo) {
		adao.updateat(attractionvo);
	}
	public void deleteat(int aseq) {
		adao.deleteat(aseq);
	}

	public void insertNotice(NoticeVO noticevo) {
		adao.insertNotice(noticevo);
		
	}

	public void noticeDelete(int nseq) {
		adao.noticeDelete(nseq);
		
	}

	public String getName(String workId) {
		return adao.getName( workId );
		
	}

	public void memberReinsert(String id, String useyn) {
		adao.memberReinsert(id, useyn);	
		
	}

	
	
	public List<Cart2VO> getAdminOrderList(String id) {
		int result=1;
		
		List<Cart2VO> cvo = adao.getAdminOrderList(id, result);
		
		return cvo;
	}



}
