package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.MapVO;

public interface MapMapper {
	
	public void insert(MapVO map);

	public void insertSelectKey(MapVO map);
	
	public MapVO read(Long mno);
	
	public int delete(Long mno);
	
	public int update(MapVO map);
	
	public List<MapVO> getList();
	
	public List<MapVO> getListWithPaging(Criteria cri);
	
}
