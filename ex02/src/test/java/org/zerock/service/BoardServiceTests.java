package org.zerock.service;

import static org.junit.Assert.assertNotNull;import java.nio.channels.NonReadableChannelException;

import javax.swing.border.Border;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
		
		@Setter(onMethod_ = @Autowired )
		private BoardService service;
		
		
		@Test
		public void testExist() {
			log.info(service);
			assertNotNull(service);
		}
		
//		@Test
//		public void testRegister() {
//			BoardVO board = new BoardVO();
//			board.setTitle("ServiceRegister");
//			board.setContent("isItSuccessful?");
//			board.setWriter("남씨");
//			
//			service.register(board);
//			
//			log.info(board);
//			
//			
//		}
		
		@Test
		public void testGetList() {
			
			service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
			
			
		}
//		
		@Test
		public void testGet() {
			log.info(service.get(28L));
			
		}
		
		@Test
		public void testUpdate() {
			

			
			BoardVO board = service.get(23L);
			
			if(board == null) {
				return ;
			}
			
			board.setContent("도지코인");
			
			log.info("MODIFY........"+ service.modify(board));
			
		}
		
		@Test
		public void testDelete() {
			
		 BoardVO board = service.get(23L);
		 if(board == null) {
			 return;
		 }
		
		log.info("REMOVE..........."+service.remove(23L));
		}
		
		
		
		
		
}
