package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// VO(Value Object) : 여러개의 값의 저장 묶음

// 컴파일 타임에 메소드를 자동으로 만들어 준다.
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class CarVO {
	String model;
	int price;
	String color;
}
