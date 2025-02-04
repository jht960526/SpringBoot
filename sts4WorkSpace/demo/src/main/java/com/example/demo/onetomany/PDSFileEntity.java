package com.example.demo.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Builder
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "tbl_pdsfile")
public class PDSFileEntity {
	//has no identifier 오류는 PK가 없음을 의미한다.
	@Id // 필수
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY:auto increment Auto이면 sequence가 생성됨
	Long fno;
	String filename;
}
