package com.example.demo.manytoone;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseEmailCountDTO {
	String customerName;
	Long count;
}
