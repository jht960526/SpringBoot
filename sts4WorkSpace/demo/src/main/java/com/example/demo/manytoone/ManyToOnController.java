package com.example.demo.manytoone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/q")
public class ManyToOnController {
	
	@Autowired
	EmailBookService emailService;
	
	@GetMapping("/one/{bookid}")
	public EmailBookEntity q1(@PathVariable Long bookid) {
		return emailService.q1(bookid);
	}
	
	@GetMapping("/two/{customerid}")
	public List<EmailBookEntity> q2(@PathVariable String customerid) {
		return emailService.q2(customerid);
	}
	
	@GetMapping("/three")
	public List<ResponseEmailCountDTO> q3() {
		return emailService.q3();
	}
}
