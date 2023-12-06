package com.example.world.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.world.dto.AttractionVO;

@Mapper
public interface IAttractionDao {

	ArrayList<AttractionVO> getBestattraction();

	AttractionVO getAttraction(int aseq);

	List<AttractionVO> getrestattraction();

	List<AttractionVO> getAseqList();

	ArrayList<AttractionVO> getBannerList();

	


}
