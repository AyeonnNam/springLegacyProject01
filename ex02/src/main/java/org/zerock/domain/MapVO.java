package org.zerock.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	
	
	
	public MapVO(String name, Type type, Date dueDate, Double lat, Double lon) {
		super();
		this.name = name;
		this.type = type;
		this.dueDate = dueDate;
		this.lat = lat;
		this.lon = lon;
	}




	public MapVO(Long mno, String name, Type type, Date dueDate, Date regDate, Date updateDate, Double lat,
			Double lon) {
		super();
		this.mno = mno;
		this.name = name;
		this.type = type;
		this.dueDate = dueDate;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.lat = lat;
		this.lon = lon;
	}




	public MapVO() {
		super();
	}


	

	
	
	
	
	
	
}
