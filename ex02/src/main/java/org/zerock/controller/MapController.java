package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.MapVO;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.service.MapService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RequestMapping("/main/")
@RestController
public class MapController {

	private MapService service;
	
	//메인 지도에 전체 데이터 뿌려주기  
	@GetMapping(value = "/map", produces = { MediaType.APPLICATION_XML_VALUE,
		MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<MapVO>> getList() { 
		
		log.info("Get List.............main.........");
		return new ResponseEntity<List<MapVO>>(service.getList(), HttpStatus.OK);		
	}
	
	
	
	
}
