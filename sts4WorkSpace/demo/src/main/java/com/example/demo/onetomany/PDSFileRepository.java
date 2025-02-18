package com.example.demo.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PDSFileRepository extends JpaRepository<PDSFileEntity,Long> {
	//@Query : Select
	
	//select문이 아닌 DML를 수행하기
	@Modifying
	@Query(value = "delete from tbl_pdsfile where pdsno is null ", nativeQuery = true)
	public void fileDelete();
}
