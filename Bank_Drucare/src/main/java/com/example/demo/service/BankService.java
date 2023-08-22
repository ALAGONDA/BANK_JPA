package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BankDao;
import com.example.demo.dto.Bank;
import com.example.demo.response.Response;

@Service
public class BankService {

	@Autowired
	private BankDao bankDao;

	public Response<?> insert(Bank bank) {
		Bank insert = bankDao.insert(bank);

		Response<Bank> response = new Response<>();
		response.setData(insert);
		response.setHttpStatus(HttpStatus.OK);
		response.setMsg("Data inserted");

		return response;

	}

	public Response<?> update(Bank bank) {

		int update = bankDao.update(bank);

		Response<Integer> response = new Response<>();
		response.setData(update);
		response.setHttpStatus(HttpStatus.OK);
		response.setMsg("Data updated based on ifsc code");

		return response;

	}

	public Response<?> updateData(Bank bank) {
		Bank updateData = bankDao.updateData(bank);
		Response<Bank> response = new Response<>();
		response.setData(updateData);
		response.setHttpStatus(HttpStatus.OK);
		response.setMsg("Data updated based on bank id");
		
		return response;

	}

	public Response<List<Bank>> getBank() {
		 List<Bank> bank = bankDao.getBank();
		 Response<List<Bank>> response = new Response<>();
			response.setData(bank);
			response.setHttpStatus(HttpStatus.OK);
			response.setMsg("Data Fetched");
			
			return response;
		 

	}

	public void deleteById(int userid) {
		bankDao.deleteById(userid);
	
	}

	public Response<?> findBankDetailsByPage(Optional<Integer> pageNo, Optional<Integer> pageSize,
			Optional<String> sortByBankName) {
		 Page<Bank> findBankDetailsByPage = bankDao.findBankDetailsByPage(pageNo, pageSize, sortByBankName);
		 
		 Response<Page<Bank>> response = new Response<>();
			response.setData(findBankDetailsByPage);
			response.setHttpStatus(HttpStatus.OK);
			response.setMsg("find BankDetails based on Page");
			
			return response;

	}

	public Response<?> sortBankDetailsByCode() {
		 List<Bank> sortBankDetailsByCode = bankDao.sortBankDetailsByCode();
		 
		 Response<List<Bank>> response = new Response<>();
			response.setData(sortBankDetailsByCode);
			response.setHttpStatus(HttpStatus.OK);
			response.setMsg("sort bank details ");
			
			return response;
		 

	}

}
