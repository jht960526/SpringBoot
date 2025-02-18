package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo.entity.BoardEntity;

// Repository 설계: DB 객체와 연결된 entity? BoardEntity, PK의 타입
// JPA가 구현 객체를 만들어준다.
public interface BoardRepository 
	extends CrudRepository<BoardEntity, Long>,
		PagingAndSortingRepository<BoardEntity,Long>{
	
	//1. 기본 CrudRepository를 상속받으면 기본 메서드 지원 : findAll(), findById(), save()
	//2. 규칙에 맞는 함수를 정의하기
	List<BoardEntity> findByWriter(String writer); //where Writer = ?
	List<BoardEntity> findByContentLike(String content); //where Content Like?
	List<BoardEntity> findByContentContaining(String content); //where Content Like '%'||?||"%"
	
	// where bno >=? and bno <=?
	List<BoardEntity> findByBnoGreaterThanEqualAndBnoLessThanEqual(Long bno1, Long bno2);
	
	// where bno between ? and ?
	List<BoardEntity> findByBnoBetween(Long bno1, Long bno2);
	
	// where title like '%' ||?
	// where title like ?||'%'
	// where title like ?||'%' and (bno between ? and ?) order by bno desc
	
	List<BoardEntity> findByTitleStartingWith(String keyword);
	List<BoardEntity> findByTitleEndingWith(String keyword);
	List<BoardEntity> findByTitleEndingWithAndBnoBetweenOrderByBnoDesc(String keyword, Long bno1, Long bno2);
	
	}
