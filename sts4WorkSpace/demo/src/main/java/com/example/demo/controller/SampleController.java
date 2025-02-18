package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SpringComponent1;
import com.example.demo.dto.CarVO;

//@Controller ==> 수행 후 page가 forward
//@Controller + @ResponsBody
@RestController
public class SampleController {
	
	@GetMapping("/")
	public String f0() {
		return "welcom!!! 환영합니다.";
	}
	
	@GetMapping("/hello1")
	public String f1() {
		return "1";
	}
	
	// Jackson 라이브러리가 JSON으로 변경하여 보내준다.
	// {키: 값,model:""}
	@GetMapping("/hello2")
	public CarVO f2() {
		CarVO c1 = CarVO.builder().
				model("ABC모델")
				.price(1000)
				.color("Black")
				.build(); 
		return c1;
	}
	
	@GetMapping("/hello3")
	public List<CarVO> f3() {
		
		List<CarVO> carlist = new ArrayList<>();
		
		IntStream.rangeClosed(1, 5).forEach(i->{
			CarVO c1 = CarVO.builder()
					.model("ABC모델" + i)
					.price(1000 * i)
					.color("Black")
					.build();
			carlist.add(c1);
		});
		
		return carlist;
	}
	
	@Autowired
	SpringComponent1 comp1;
	
	@GetMapping("/hello4")
	public String f4() {
		return comp1.getData();
	}
	
}
