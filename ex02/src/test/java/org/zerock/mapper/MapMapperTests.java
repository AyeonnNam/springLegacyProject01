package org.zerock.mapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MapVO;
import org.zerock.domain.Type;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private MapMapper mapper;
	
//	@Test
//	public void testInsert() {
//		
//		MapVO map = new MapVO();
//		
//		map.setName("Espresso Boutique");
//		map.setType(Type.CAFE);
//		map.setLat(37.561367);
//		map.setLon(126.922088);
//		
//		
//		mapper.insert(map);
//		log.info("insert....................." + map);
//	}
//	
//	@Test
//	public void testInsertSelectKey() {
//		
//		MapVO map = new MapVO();
//		
//		map.setName("Espresso Boutique");
//		map.setType(Type.CAFE);
//		map.setLat(37.561367);
//		map.setLon(126.922088);
//		
//		mapper.insertSelectKey(map);
//		log.info("insertSelectKey....................." + map);
//	}

//	@Test
//	public void testRead() {
//		
//		log.info("Read........................." + mapper.read(7L));
//		
//	}
//	
//	@Test
//	public void testDelete() {
//	
//		int count = mapper.delete(7L);
//		
//		
//		log.info("Delete Count........................." + count);
//		
//	}

	
//	@Test
//	public void testUpdate() {
//		
//		MapVO map = new MapVO();
//		map.setMno(8L);
//		map.setName("에스프레소 부띠끄");
//		
//		
//		int count = mapper.update(map);
//		
//		log.info("Update Count........................." + count);
//		
//		
//	}
//	

}
