package com.lec.ch13.dao;

import java.util.List;

import com.lec.ch13.dto.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp emp);  //Emp.xml안에있는select
}
