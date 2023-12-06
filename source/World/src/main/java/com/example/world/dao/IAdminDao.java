package com.example.world.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.world.dto.AdminVo;
import com.example.world.dto.AttractionVO;
import com.example.world.dto.BannerVO;
import com.example.world.dto.Cart2VO;
import com.example.world.dto.NoticeVO;
import com.example.world.dto.Paging;
import com.example.world.dto.QnaVO;


@Mapper
public interface IAdminDao {

	String getPwd(String workId);

	//공지사항
	int getAllCount(String string, String string2, String key);
	List<AdminVo> listNotice(Paging paging, String key);
	Object viewNotice(int nseq);
	void updateNotice(NoticeVO noticevo);

	
	// 배너
	List<BannerVO> getBannerList();
	void insertBanner(BannerVO bannervo);
	void updateSeq(int changeval, String useyn, int bseq);
	void deleteBanner(int bseq);
	
	//qna
	List<QnaVO> listQna(Paging paging, String key);
	void updateQna(int lqseq, String reply);

	//Member
	List<QnaVO> listMember(Paging paging, String key);

	//Attraction
	List<QnaVO> listAttraction(Paging paging, String key);
	void insertat(AttractionVO attractionvo);
	void insertNotice(NoticeVO noticevo);
	void updateat(AttractionVO attractionvo);
	void deleteat(int aseq);

	void noticeDelete(int nseq);

	String getName(String workId);

	void memberReinsert(String id, String useyn);

	List<Cart2VO> getAdminOrderList(String id, int result);
	

}


