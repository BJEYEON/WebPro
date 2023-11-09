package com.lec.ch13.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Data;

@Controller
public class HomeController {
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
}
