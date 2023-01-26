package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MapVO {
	
	private Long mno;
	private String name;
	private Type type;
	private Date dueDate;
	private Date regDate;
	private Date updateDate;
	private Double lat;	//위도
	private Double lon;	//경도
	
	
}
