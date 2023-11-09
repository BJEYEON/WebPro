package com.lec.ch13.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch13.dto.Emp;
@Repository
public class EmpDaompl implements EmpDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Override
	public List<Emp> empList(Emp emp) { //select안에있는파라미터
		return sessionTemplate.selectList("empList", emp);
	}

}
