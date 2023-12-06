package com.example.world.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AttractionVO {
		private Integer aseq;
		@NotEmpty(message="어트랙션 이름을 입력하세요")
		private String atname;
		@NotEmpty(message="어트랙션 설명을 입력하세요")
		private String acontent;
		@NotEmpty(message="어트랙션 카테고리1을 입력하세요")
		private String act1;
		@NotEmpty(message="어트랙션 카테고리2을 입력하세요")
		private String act2;
		@NotEmpty(message="어트랙션 이미지를 입력하세요")
		private String image;
		private Integer pnum;
		@NotEmpty(message="어트랙션 키제한을 입력하세요")
		private String limitkey;
		@NotEmpty(message="어트랙션 나이제한사항을 입력하세요")
		private String limitage;
		@NotEmpty(message="어트랙션 베스트정보를 입력하세요")
		private String bestat;
		@NotEmpty(message="어트랙션 운휴정보를 입력하세요")
		private String aresult;
		
		
		
	
		
		
		
		
	
		
	
}
