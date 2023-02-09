package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.MapCriteria;
import org.zerock.domain.MapVO;
import org.zerock.mapper.MapMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class MapServiceImpl implements MapService {
	
	private MapMapper mapper;

	@Override
	public void register(MapVO map) {
		log.info("register.................." + map);
		mapper.insertSelectKey(map);
	}

	@Override
	public MapVO get(Long mno) {
		MapVO map = mapper.read(mno);
		log.info("get.................." + map);
		return map;
	}

	@Override
	public boolean modify(MapVO map) {
		log.info("modify.............." + map);
		return mapper.update(map) == 1;
	}

	@Override
	public boolean remove(Long mno) {
		log.info("remove................" + mno);
		return mapper.delete(mno) == 1;
	}

	@Override
	public List<MapVO> getList(MapCriteria cri) {
		log.info("getList.................." );
		return mapper.getListWithPaging(cri);
	}

}
