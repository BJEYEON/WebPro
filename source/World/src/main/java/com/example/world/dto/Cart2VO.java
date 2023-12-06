package com.example.world.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Cart2VO {
	private Integer cseq;
	private String id;
	private Integer p1;
	private Integer p2;
	private Integer kind;
	private String tatname1;
	private String tatname2;
	private String tatname3;
	private Integer price1;
	private Integer price2;
	private Integer result;
	private Timestamp indate;
	private LocalDate visitdate;
}
