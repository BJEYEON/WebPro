package com.lec.emp;

import java.sql.Date;
import java.sql.Timestamp;

public class EmpDto {
	private int empno;
	private String ename;
	private String job;
	private int mgr; // mgr이null이면 0으로 가져옴
	private Timestamp hiredate;
	private Date hireDate;
	private int sal;
	private int comm;
	private int deptno;
	public EmpDto() {}
	public EmpDto(int empno, String ename, String job, int mgr, Timestamp hiredate, Date hireDate2, int sal, int comm,
			int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		hireDate = hireDate2;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Timestamp getHiredate() {
		return hiredate;
	}
	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "EmpDto [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", hireDate=" + hireDate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
}
