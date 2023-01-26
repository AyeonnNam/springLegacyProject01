package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.MapVO;

@Service
public interface MapService {

	
	public void register(MapVO map);

	public BoardVO get(Long mno);

	public boolean modify(MapVO map);

	public boolean remove(Long mno);
	
	public List<MapVO> getList();
	
}
