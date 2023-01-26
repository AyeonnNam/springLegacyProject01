package org.zerock.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
		
	
		@Setter(onMethod_ = @Autowired )
		private BoardMapper boardMapper;
		
		@Test
		public void testGetList() {
			boardMapper.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
		}
		
		
		
//		@Test
//		public void testInsert() {
//			BoardVO board = new BoardVO();
//			board.setTitle("test1");
//			board.setContent("test11");
//			board.setWriter("시시껄껄");
//			
//				boardMapper.insert(board);
//				log.info(board);
//		}
//		
//		
//		@Test
//		public void testInsertSelectKey() {
//			BoardVO board = new BoardVO();
//			board.setTitle("test2insertSelectKey");
//			board.setContent("selectKey");
//			board.setWriter("젠틀몬스터");
//			
//			boardMapper.insertSelectKey(board);
//			log.info(board);
//		}
		
		
		
//		@Test
//		public void testRead() {
//			BoardVO board = boardMapper.read(24L);
//			
//			log.info(board);
//		}
//		
//		
//		@Test
//		public void testDelete() {
//			int count = boardMapper.delete(24L);
//			
//			log.info("DELETE COUNT : " + count);
//		}
//		
//		@Test
//		public void testUpdate() {
//			
//		BoardVO board = new BoardVO();		
//		board.setBno(23L);
//		board.setTitle("화성갈끄니까");
//		board.setContent("가즈아_가보자고");
//		board.setWriter("김홍남");
//		
//		
//			log.info("UPDATE COUNT: " + boardMapper.update(board));
//		}
//	
		@Test
		public void testPaging() {
		
		Criteria cri = new Criteria();
		//10개씩 3페이지 
		cri.setAmount(10);
		cri.setPageNum(3);
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
		
			
		}
		
		
		@Test
		public void testSearch() {
			Criteria cri = new Criteria();
			cri.setAmount(10);
			cri.setPageNum(5);
			cri.setKeyword("배고파");
			cri.setType("T");
			
			List<BoardVO> list = boardMapper.getListWithPaging(cri);
			list.forEach(board -> log.info(board));
		}
		
		
}
