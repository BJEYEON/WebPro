package com.lec.ch13.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch13.dto.Dept;
@Repository
public class DeptDaompl implements DeptDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<Dept> deptList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("deptList");
	}

}
