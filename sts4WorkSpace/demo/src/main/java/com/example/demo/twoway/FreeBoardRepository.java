package com.example.demo.twoway;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

//Repository<====CrudRepository<---PagingAndSortingRepository<----JpaRepository
public interface FreeBoardRepository 
extends JpaRepository<FreeBoardEntity,Long>,
		QuerydslPredicateExecutor<FreeBoardEntity>
{
	
	//1. 기본제공 메서드 이용 findAll(), findById()
	// JpaRepository ==> findAll(Pageable)
	// QuerydslPredicateExecutor => findAll(Predicate)
	//2. 규칙에 맞는 함수 정의 추가하기
	// 특정 writer가 작성한 board 조회
	List<FreeBoardEntity>findByWriter(String ww);
	
	Page<FreeBoardEntity> findByWriter(String ww, Pageable pageable);
	
	//3. JPQL 사용하기 ..함수이름 규칙없음
	
	@Query(" select board.title, count(reply) "
			+ " from FreeBoardEntity board join FreeReplyEntity reply"
			+ " on ( board = reply.board ) "
			+ " group by board.title "
			+ " order by board.title ")
	public List<Object[]> getBoardInfo();
	
	@Query(" select board.title, count(reply) "
			+ " from FreeBoardEntity board join board.replies"
			+ " group by board.title "
			+ " order by board.title ")
	public List<Object[]> getBoardInfo2();
	
	
	// nativeQuery는  권장안함
	@Query(value = " select board.title, count(reply) "
			+ " from tbl_freeboard board join tbl_free_replies reply"
			+ " on ( board.bno = reply.board_bno ) "
			+ " group by board.title "
			+ " order by board.title ", nativeQuery = true)
	public List<Object[]> getBoardInfo3();
}
