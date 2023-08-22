package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Bank;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

public interface BankRepo extends JpaRepository<Bank, Integer>{
	
//	 @Transactional annotation ensures that the operation is performed within a transaction.
//     @Modifying annotation indicates that the query will modify the database.
	
	@Transactional
	@Modifying
	@Query("update Bank b set b.bankname=:name, b.address=:address, b.branch=:branch where b.ifsccode=:ifsccode")
    int updateByBankIfscCode(@PathParam("name")String name,@PathParam("address")String address,@PathParam("branch")String branch,@PathParam("ifsccode")String ifsccode);

	
	 @Query("SELECT b FROM Bank b ORDER BY b.bankname, b.branch DESC")
	    public List<Bank> findAllSortedByIfscCode();
}
