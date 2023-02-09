package org.zerock.mapper;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
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
	
	MapVO mapVO = new MapVO("sinkhole",Type.CAFE,null,37.5508953, 126.9220198);
	MapVO mapVO2 =new MapVO("coffeeAndCigarette", Type.CAFE, null, 37.5626729, 126.9740609);
	MapVO mapVO3 =new MapVO("카페동네", Type.CAFE, null, 37.5089055, 126.8651317);
	MapVO mapVO4 =new MapVO("선유도공원", Type.CAFE, null, 37.5423833, 126.9018193);
	MapVO mapVO5 =new MapVO("강남센트럴푸르지오시티", Type.CAFE, null, 37.4976709, 127.0293410);
	MapVO mapVO6 =new MapVO("대우도씨에빛2오피스텔", Type.CAFE, null, 37.4948012, 127.0286234);
	MapVO mapVO7 =new MapVO("할리스 선유도역점TS카페", Type.CAFE, null, 37.5367364, 126.8967928);
	MapVO mapVO8 =new MapVO("나이키강남", Type.CAFE, null, 37.5024003, 127.0259642);
	MapVO mapVO9 =new MapVO("파머스영어", Type.CAFE, null, 37.4923700, 127.0258645);
	MapVO mapVO10 =new MapVO("아틀리에", Type.CAFE, null, 37.5352209, 126.9932353);
	
	
	private final List<MapVO> mapList = Stream
			.of(mapVO,mapVO2,mapVO3,mapVO4,mapVO5,mapVO6,mapVO7,mapVO8,mapVO9,mapVO10)
			.collect(Collectors.toList());
			
	
	
//	@Test
//	public void testInsert() {
//			mapList.forEach(map ->mapper.insert(map));
//		
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
//	
//	@Test
//	public void getList(Criteria cri) {
//		
//		List<MapVO> list = mapper.getList();
//		list.forEach(map -> log.info(map));
//		
//		
//	}
	
	@Test
	public void testPaging() {
		
       Criteria cri = new Criteria();
       cri.setPageNum(2);
       cri.setAmount(10);
       List<MapVO> list = mapper.getListWithPaging(cri);
       list.forEach(map -> log.info(map.getMno()));
       
       
	}

	
	
}
