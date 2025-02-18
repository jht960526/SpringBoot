package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.onetoone.UserCellPhoneEntity;
import com.example.demo.onetoone.UserCellPhoneEntity2;
import com.example.demo.onetoone.UserCellPhoneEntity3;
import com.example.demo.onetoone.UserCellPhoneRepository;
import com.example.demo.onetoone.UserCellPhoneRepository2;
import com.example.demo.onetoone.UserCellPhoneRepository3;
import com.example.demo.onetoone.UserEntity;
import com.example.demo.onetoone.UserEntity2;
import com.example.demo.onetoone.UserEntity3;
import com.example.demo.onetoone.UserRepository;
import com.example.demo.onetoone.UserRepository2;
import com.example.demo.onetoone.UserRepository3;

@SpringBootTest
public class OneToOneTest {
	//주 table을 이용해서 CRUD
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserCellPhoneRepository phoneRepo;
	
	//부 table을 이용해서 CRUD
	@Autowired
	UserRepository2 userRepo2;
	
	@Autowired
	UserCellPhoneRepository2 phoneRepo2;
	
	@Autowired
	UserRepository3 userRepo3;
	
	@Autowired
	UserCellPhoneRepository3 phoneRepo3;
	
	@Test
	void f4() {
		UserCellPhoneEntity3 phone = UserCellPhoneEntity3.builder()
				.phoneNumber("010-8867-1577")
				.model("DDD모델")
				.build();
		
		UserEntity3 user = UserEntity3.builder()
				.userid("hyun1004")
				.username("종현")
				.phone(phone)
				.build();
		
		phone.setUser3(user); // 주의!!....user에 cascade = CascadeType.ALL
		userRepo3.save(user);
		
	}
	
	
	//부 테이블을 이용해서 주 테이블 insert
	//@Test
	void f2() {
		UserEntity2 user = UserEntity2.builder()
				.userid("hyun1004")
				.username("호택")
				.build();
		
		UserCellPhoneEntity2 phone = UserCellPhoneEntity2.builder()
				.phoneNumber("010-7777-5678")
				.model("아이폰21")
				.user(user)
				.build();
		phoneRepo2.save(phone);
	}
	
	
	// 주 table을 이용해서 부table에 insert
	//@Test
	void f1() {
		
		UserCellPhoneEntity phone = UserCellPhoneEntity.builder()
				.phoneNumber("010-1234-5678")
				.model("아이폰16")
				.build();
		UserCellPhoneEntity newPhone =  phoneRepo.save(phone);
		
		UserEntity user = UserEntity.builder()
				.userid("qoqo11")
				.username("정홍택")
				.phone(newPhone)
				.build();
		userRepo.save(user);
		
		
	}
}
