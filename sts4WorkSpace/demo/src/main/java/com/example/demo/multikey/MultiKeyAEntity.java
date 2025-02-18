package com.example.demo.multikey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@IdClass(MultiKeyA.class)
@Entity
@Table(name = "tbl_child1")

public class MultiKeyAEntity {
	@Id
	Integer orderId;
	
	@Id
	Integer productId;
	String title;
	int count;
}
