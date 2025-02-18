package com.example.demo.manytoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "tbl_customer")
public class CustomerEntity {
	
	
	@Id // Primary key임을 의미(없으면 오류)
	@Column(name="customer_id")
	String customerId; //@Column생략 시, DB에 컬럼 : customer_id
	String customerName; // customer_name
	String customerPhone; // customer_phone
}
