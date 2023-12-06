package com.example.world.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.world.dto.Paging;
import com.example.world.dto.QnaVO;

@Mapper
public interface IQnaDao {

	int getAllCount(String string, String string2, String key);

	List<QnaVO> listQna(Paging paging, String key);

	QnaVO getQna(int lqseq);

	void insertQna(QnaVO qnavo);

}
