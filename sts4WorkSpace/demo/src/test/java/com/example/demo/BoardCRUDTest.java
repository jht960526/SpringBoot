package com.example.demo;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.BoardEntity;
import com.example.demo.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardCRUDTest {
	
	@Autowired
	BoardRepository boardRepo; // BoardRepository인터페이스 구현 class가 Injection된다.
	
	@Test
	public void f6() {
		// 페이지 번호는 0부터 시작
		//Pageable pageable = PageRequest.of(0, 5);
		//Pageable pageable = PageRequest.of(0, 5,Sort.by("bno").ascending());
		
		String[] columns = {"writer","bno"};
		Pageable pageable = PageRequest.of(0, 5,Sort.Direction.DESC,"bno");
		Page<BoardEntity> result = boardRepo.findAll(pageable);
		
		log.info("getSize:" + result.getSize());
		log.info("getNumber:" + result.getNumber());
		log.info("getTotalPage:" + result.getTotalPages());
		log.info("getTotalElements:" + result.getTotalElements());
		List<BoardEntity> blist = result.getContent();
		blist.forEach(board->{
			log.info(board.toString());
		});
	}
	
	
	//@Test
	public void f5() {
		boardRepo.findByTitleEndingWithAndBnoBetweenOrderByBnoDesc("7",27L,67L).forEach(board->{
			log.info(board.toString());
		});
	}
	
	
	//@Test
	public void f4() {
		boardRepo.findByTitleEndingWith("7").forEach(board->{
			log.info(board.toString());
		});
	}
	
	
	//@Test
	public void f3() {
		boardRepo.findByTitleStartingWith("토").forEach(board->{
			log.info(board.toString());
		});
	}
	
	//@Test
	public void f2() {
		boardRepo.findByBnoGreaterThanEqualAndBnoLessThanEqual(10L,15L).forEach(board->{
			log.info(board.toString());
		});
		
		log.info("between--------------");
		boardRepo.findByBnoBetween(10L, 15L).forEach(board->{
			log.info(board.toString());
		});
	}
	
	
	//@Test
	public void f1() {
		boardRepo.findByContentLike("%말자%").forEach(board->{
			log.info(board.toString());
		});
	}
	
	//@Test
		public void selectByContent() {
			boardRepo.findByContentContaining("말자").forEach(board->{
				log.info(board.toString());
			});
		}
		
	
	
	//@Test
	public void selectByWriter() {
		boardRepo.findByWriter("user7").forEach(board->{
			log.info(board.toString());
			board.setContent("졸지말자");
			boardRepo.save(board);
		});
	}
	
	
	//@Test
	public void delete() {
		log.info("delete before:"+ boardRepo.count());
		boardRepo.deleteById(99L);
		log.info("delete before:"+ boardRepo.count());
	}
	
	
	//@Test
	public void update() {
		boardRepo.findById(90L).ifPresentOrElse(b->{
			log.info("찾음:" + b.toString());
			b.setTitle("제목변경");
			b.setContent("금요일은 강점교육");
			b.setWriter("admin");
			boardRepo.save(b); // 입력과 수정은 save함수를 이용한다.
		},()->{
			log.info("못찾음");
		});
	}
	
	
	
	
	//@Test
	public void selectById() {
		BoardEntity board=  boardRepo.findById(90L).orElse(null);
		log.info(board==null?"not found":board.toString());
		
		BoardEntity board2=  boardRepo.findById(190L).orElse(null);
		log.info(board2==null?"not found":board2.toString());
		
		boardRepo.findById(81L).ifPresentOrElse(b->{
			log.info("찾음:" + b.toString());
		},()->{
			log.info("못찾음");
		});
	}
	
	
	//@Test
	public void select() {
		boardRepo.findAll().forEach(board->{
			log.info(board.toString());
		});
	}
	
	
	//@Test
	public void insert() {
		IntStream.rangeClosed(1, 100).forEach(i->{
			BoardEntity board = BoardEntity.builder()
					.title("목요일")
					.content("배고파")
					.writer("user"+(i%10+1))
					.build();
			
			boardRepo.save(board);
		});
	}
	
	
	//@Test
	public void insert2() {
			BoardEntity board = BoardEntity.builder()
					.title("토요일")
					.content("놀자~~")
					.writer("member")
					.build();
			boardRepo.save(board); //insert into~~
	}
	
}
