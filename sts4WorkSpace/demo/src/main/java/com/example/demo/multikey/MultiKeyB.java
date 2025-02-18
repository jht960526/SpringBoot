package com.example.demo.multikey;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Embeddable
public class MultiKeyB implements Serializable{
	Integer orderId; // 주문 번호
	Integer productId; //상품 번호
}
