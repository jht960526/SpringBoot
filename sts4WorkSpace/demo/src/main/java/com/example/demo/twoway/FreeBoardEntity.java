package com.example.demo.twoway;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter @Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_freeboard")
public class FreeBoardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	
	@NonNull // 자바에서 설정
	@Column(nullable = false) //DB설정
	private String title;
	private String writer;
	private String content;
	@CreationTimestamp  //insert시 자동값(insert시각)
	private Timestamp regdate;
	@UpdateTimestamp //insert시 자동값(insert시각), update시 자동값(update 시각)
	private Timestamp updatedate;
	
	//하나의 board는 여러개의 Reply를 갖는다.
	@BatchSize(size=100) 
	// from tbl_free_replies r1_0 where r1_0.board_bno = 1
	// from tbl_free_replies r1_0 where r1_0.board_bno = 2
	// --> from tbl_free_replies r1_0 where r1_0.board
	// cascade = CascadeType
	@OneToMany( mappedBy = "board",
			cascade = CascadeType.ALL, fetch = FetchType.EAGER) // EAGER 즉시 로딩, LAZY 지연로딩
	List<FreeReplyEntity> replies;
}
