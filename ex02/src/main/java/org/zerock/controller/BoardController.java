package org.zerock.controller;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

	private BoardService service;

	// 목록에 대한 처리
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {

		log.info("list" + cri);
		model.addAttribute("list", service.getList(cri));

		int total = service.getTotal(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	// 등록에 대한 처리
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info("/register" + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";

	}

	// 조회처리
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

	// 변경처리
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr, Criteria cri) {

		log.info("/modify" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");

		}

//			rttr.addAttribute("pageNum", cri.getPageNum());
//			rttr.addAttribute("amount", cri.getAmount());	
//			rttr.addAttribute("type",cri.getType());
//			rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list" + cri.getListLink();
	}

	// 삭제처리
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr, Criteria cri) {

		log.info("/remove" + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}

//			rttr.addAttribute("pageNum", cri.getPageNum());
//			rttr.addAttribute("amount", cri.getAmount());
//			rttr.addAttribute("type",cri.getType());
//			rttr.addAttribute("keyword", cri.getKeyword());
//			

		return "redirect:/board/list" + cri.getListLink();

	}

	// 입력 페이지를 보여주는 역할
	@GetMapping("/register")
	public void register() {
	}

}
