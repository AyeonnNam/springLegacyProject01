package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MapCriteria {

	private int pageNum;
	private int amount;
	private String type;
	private String keyword;

	public MapCriteria() {
		this(1, 9);
	}
	
	
	
	

	public MapCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}

	public String getListLink() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", this.getPageNum())
				.queryParam("amount", this.getAmount()).queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());

		return builder.toUriString();

	}

}
