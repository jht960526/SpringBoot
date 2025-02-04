package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.twoway.FreeBoardEntity;


@Controller
@RequestMapping("/section1")
public class HelloController {
	
	@GetMapping("/hello1")
	public void f1(Model model) {
		model.addAttribute("myname","jin");
		model.addAttribute("myscore","99");
		FreeBoardEntity board = FreeBoardEntity.builder()
				.title("스프링부트")
				.content("타임리프 사용하기")
				.writer("jj")
				.build();
		model.addAttribute("board", board);
	}
	
	@GetMapping("/hello2")
	public String f2() {
		return "section1/hello1"; //templates/section1/hello1.html
	}
}
