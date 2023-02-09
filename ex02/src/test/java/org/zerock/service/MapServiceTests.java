package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.MapVO;
import org.zerock.domain.Type;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapServiceTests {
	
		@Setter(onMethod_ = @Autowired)
		private MapService service;
		
		
		@Test
		public void testExist() {
			log.info(service);
			assertNotNull(service);
		}
		
//		@Test
//		public void testRegister() {
//			
//			MapVO map = new MapVO();
//			
//			map.setName("Espresso Boutique");
//			map.setType(Type.CAFE);
//			map.setLat(37.561367);
//			map.setLon(126.922088);
//			
//			service.register(map);
//			
//			log.info("register........." + map);
//		}
		
		@Test
		public void testGetList() {
			
			Criteria cri = new Criteria();
			service.getList(cri).forEach(map -> log.info(map));
			
		}
		
//		@Test
//		public void testGet() {
//			MapVO map = service.get(15L);
//			
//			log.info("Get..............." +map);
//			
//			
//		}
		
//		@Test
//		public void testModify() {
//			
//			MapVO map = new MapVO();
//			map.setMno(15L);
//			map.setName("Hollys 선유도역점TS카페");
//			 boolean isModified = service.modify(map);
//			
//			log.info("Modify isModified..................." + isModified );
//			
//		}
		
//		@Test
//		public void testRemove() {
//			
//			boolean isRemoved = service.remove(20L);
//			
//			log.info("Remove.................." + isRemoved);
//			
//		}
//		
		
	
}
