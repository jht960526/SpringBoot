package com.example.demo.manytoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity //table DDL 만들어짐 (create table CustomerEntity~~~)
@Table(name = "tbl_emailbook")
public class EmailBookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	private Long bookId;
	@Column(length = 100)
	private String email;
	private String password;
	boolean mainYn; // main_yn
	
	@ManyToOne
	CustomerEntity cust; //customer_cust_id
}
