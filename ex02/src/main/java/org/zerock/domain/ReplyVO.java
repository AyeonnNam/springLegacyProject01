package org.zerock.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ReplyVO {

	
	
	private Long rno;
	private Long bno;
	
	private String reply;
	private String replyer;
	
	//자동으로 들어가게 됨
	private Date replyDate;
	private Date updateDate;
}
