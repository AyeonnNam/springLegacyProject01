package org.zerock.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.MapCriteria;
import org.zerock.domain.MapVO;
import org.zerock.domain.PageDTO;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.service.MapService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RequestMapping("/main/*")
@RestController
//@Controller
public class MapController {

	private MapService service;
	


	
//	@GetMapping("/showMap")
//	public void showMap(Model model, MapCriteria cri) {
//		
//		model.addAttribute("showMap",service.getList(cri) );
//		model.addAttribute("pageMaker", new PageDTO(cri, 123));
//		
//	}

	//등록작업 
	@PostMapping(value="/new", produces = {MediaType.TEXT_PLAIN_VALUE}, 
			consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody MapVO vo){
		
		int insertCount = service.register(vo);
		
		return insertCount == 1 ? new ResponseEntity<String>("success", HttpStatus.OK): 
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		
	}
	
	
	//리스트 조회 
	@GetMapping(value="/showMap/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<MapVO>> getList(MapCriteria cri){
		return new ResponseEntity<>(service.getList(cri), HttpStatus.OK);
	}

	
	
	
	
}
