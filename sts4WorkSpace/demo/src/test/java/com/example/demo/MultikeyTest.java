package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.multikey.MultiKeyAEntity;
import com.example.demo.multikey.MultiKeyB;
import com.example.demo.multikey.MultiKeyBEntity;
import com.example.demo.multikey.MultikeyARepository;
import com.example.demo.multikey.MultikeyBRepository;

@SpringBootTest
public class MultikeyTest {
	@Autowired
	MultikeyARepository aRepo;
	
	@Autowired
	MultikeyBRepository bRepo;
	
	//@Test
	public void f2() {
		MultiKeyB id = MultiKeyB.builder()
				.orderId(1)
				.productId(100)
				.build();
		MultiKeyBEntity entity = MultiKeyBEntity.builder()
				.id(id)
				.title("EmbeddedId 사용")
				.count(10)
				.build();
	}
	@Test
	public void f1() {
		MultiKeyAEntity entity = MultiKeyAEntity.builder()
				.orderId(1)
				.productId(100)
				.title("효과좋아요")
				.count(10)
				.build();
		
		MultiKeyAEntity entity2 = MultiKeyAEntity.builder()
				.orderId(1)
				.productId(200)
				.title("효과좋아요2")
				.count(5)
				.build();

		aRepo.save(entity);
		aRepo.save(entity2); 

	}	
}
