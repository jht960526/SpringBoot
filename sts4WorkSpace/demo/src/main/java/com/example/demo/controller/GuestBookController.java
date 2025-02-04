package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GuestBookDTO;
import com.example.demo.service.GuestBookService;

@RestController
@RequestMapping("/guest")
public class GuestBookController {

	@Autowired
	GuestBookService gService;
	
	@GetMapping("/list")
	public List<GuestBookDTO> selectAll(){
		return gService.selectAll();
	}
	
	@GetMapping("/list2")
	public List<GuestBookDTO> selectAll2(){
		return gService.selectAll2();
	}
}
