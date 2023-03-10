package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MapCriteria;
import org.zerock.domain.MapVO;


public interface MapService {

	
	public int register(MapVO map);

	public MapVO get(Long mno);

	public boolean modify(MapVO map);

	public boolean remove(Long mno);
	
	public List<MapVO> getList(MapCriteria cri);
	
}
