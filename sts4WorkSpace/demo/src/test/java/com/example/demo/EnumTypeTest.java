package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.MemberRole;
import com.example.demo.multikey.EnumTypeEntity;
import com.example.demo.multikey.EnumTypeRepository;

@SpringBootTest
public class EnumTypeTest {
	@Autowired
	EnumTypeRepository repo;
	
	@Test
	void select() {
		repo.findAll().forEach(m->{
			System.out.println(m.toString());
		});
	}
	
	
	//@Test
	void insert() {
		Set<MemberRole>roleSet = new HashSet <>();
		roleSet.add(MemberRole.ADMIN);
		roleSet.add(MemberRole.MANAGER);
		roleSet.add(MemberRole.USER);
		EnumTypeEntity entity = EnumTypeEntity.builder()
				.mid("firstzone")
				.mpassword("1234")
				.mname("퍼스트존")
				.mrole(roleSet)
				.build();
		repo.save(entity);
	}
}
