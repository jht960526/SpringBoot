package com.example.demo.manytoone;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity,String>,
						PagingAndSortingRepository<CustomerEntity,String>,
						QuerydslPredicateExecutor<CustomerEntity>{
						// QDomain이 자동 생성됨 .... pom.xml에 plugin으로 등록되어있음
	//1. 기본제공함수들이 있다. findAll(), findById(), save()
}
