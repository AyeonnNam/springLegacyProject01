package org.zerock.mapper;

import org.zerock.domain.MapVO;

public interface MapMapper {
	
	public void insert(MapVO map);

	public void insertSelectKey(MapVO map);
	
	public MapVO read(Long mno);
	
	public int delete(Long mno);
	
	public int update(MapVO map);
	
	
}
