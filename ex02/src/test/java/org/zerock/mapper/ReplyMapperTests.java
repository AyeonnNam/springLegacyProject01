package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@Setter
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {

	private Long[] bnoArr = {816777L,816780L,816777L,816774L, 816853L};
	
	
	@Setter(onMethod_ =  @Autowired)
	private ReplyMapper mapper;
		
	
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}		
	
	
	@Test
	public void testRead(){
		ReplyVO read = mapper.read(2L);
		log.info(read);
	}
	
	
//	@Test
//	public void testCreate() {
//		
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			
//		ReplyVO vo = new ReplyVO();
//			vo.setBno(bnoArr[i%5]);
//			vo.setReply("댓글테스트" + i);
//			vo.setReplyer("악플러" + i);
//		
//			mapper.insert(vo);
//		
//		});
//		
//	}
//	
	
	@Test
	public void testDelete() {
		
		mapper.delete(50L);
	}
	
	
	@Test
	public void testUpdate() {
		
		ReplyVO reply = mapper.read(53L);
		reply.setReply("meAndDrake");
		
		log.info("update........" + mapper.update(reply));
		
		
	}
	
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
	
		replies.forEach(reply ->  log.info("Reply............." +reply));
		 
	
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2,10);
		
		//816853L
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 816853L);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
}
