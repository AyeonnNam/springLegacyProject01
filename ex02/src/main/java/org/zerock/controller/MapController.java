package org.zerock.controller;

import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
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
//RestController
@Controller
public class MapController {

	private MapService service;
	
//	//메인 지도에 전체 데이터 뿌려주기  
//	@GetMapping("/mapList") 
//	public void mapList(Criteria cri, Model model) { 
//		log.info("mapList");
//		List<MapVO> list = service.getList(cri);
//		String jsonList = new Gson().toJson(list);
//		log.info("..............................jsonList." +jsonList);
//				
//
//		model.addAttribute("mapList", jsonList);
//		
//		
//		
//	}
	
	
	
	@GetMapping("/showMap")
	public void showMap(Model model, MapCriteria cri) {
		
		model.addAttribute("showMap",service.getList(cri) );
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		
	}

	
	
//	//메인 지도에 전체 데이터 뿌려주기  
//	@GetMapping(value = "/mapList", produces = { MediaType.APPLICATION_XML_VALUE,
//		MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public ResponseEntity<List<MapVO>> getList() { 
//		
//		log.info("Get List.............main.........");
//		return new ResponseEntity<List<MapVO>>(service.getList(), HttpStatus.OK);		
//	}
	
	
	
	
}
