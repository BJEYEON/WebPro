package com.lec.uitest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.uitest.dto.Student;
@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@ModelAttribute("num")
	public int num() {
		return 4;
	}
	@RequestMapping(value="input", method=RequestMethod.GET) //main.do요청
	public String main() {
		return "student/input";
	}
	@RequestMapping(value="input", method=RequestMethod.POST)
	public String input(Student student) {
		student.setTot(student.getEng()+student.getKor()+student.getMath());
		return "student/result";
	}
}
