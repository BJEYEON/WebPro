package com.example.world.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.world.dao.IAttractionDao;
import com.example.world.dto.AttractionVO;

@Service
public class AttractionService {

	@Autowired
	IAttractionDao atdao;

	public AttractionVO getAttraction(int aseq) {
		return atdao.getAttraction(aseq);
  }
  
	public ArrayList<AttractionVO> getBestattraction() {
		
		return atdao.getBestattraction();
	}

	public List<AttractionVO> getAseqList() {
		 return atdao.getAseqList();
	}


	public List<AttractionVO> getrestattraction() {
		
		return atdao.getrestattraction();
	}

	public ArrayList<AttractionVO> getBannerList() {
		return atdao.getBannerList();
	}
  
}
