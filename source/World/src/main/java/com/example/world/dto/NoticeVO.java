package com.example.world.dto;

import java.sql.Timestamp;

import lombok.Data;


@Data
public class NoticeVO {
	private Integer nseq; 
	private String title; 
	private String ncontent;
	private String id;
	private Timestamp indate;
}
