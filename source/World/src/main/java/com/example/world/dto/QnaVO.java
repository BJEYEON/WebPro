package com.example.world.dto;

import java.sql.Timestamp;

import lombok.Data;


@Data
public class QnaVO {
	private Integer lqseq; 
	private String title;
	private String content;
	private String reply;
	private String rep;
	private String id;
	private Timestamp indate;
	private String passcheck;
	private String pass;
	
	
	
	
}
