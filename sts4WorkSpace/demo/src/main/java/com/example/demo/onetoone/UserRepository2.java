package com.example.demo.onetoone;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository2 extends CrudRepository<UserEntity2, String> {
	
}
