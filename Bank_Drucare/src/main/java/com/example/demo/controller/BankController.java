package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Bank;
import com.example.demo.response.Response;
import com.example.demo.service.BankService;

@RestController
@RequestMapping("/app")
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/addBank")
	public Response<?> insert(@RequestBody Bank bank) {
		Response<?> insert = bankService.insert(bank);
		return insert;

	}

	@PutMapping("/updateBank")
	public Response<?> update(@RequestBody Bank bank) {
		// System.out.println(bank);
		Response<?> update = bankService.update(bank);

		return update;
	}

	@PutMapping("/updateBankDetails")
	public Response<?> updateData(@RequestBody Bank bank) {
		// System.out.println(bank);
		Response<?> updateData = bankService.updateData(bank);

		return updateData;
	}

	@GetMapping("/getbanks")
	public Response<?> getBanks() {
		Response<List<Bank>> bank = bankService.getBank();
		return bank;

	}

	@DeleteMapping("/delete/{userid}")
	public void deleteById(@PathVariable int userid) {
		bankService.deleteById(userid);
	}

	@GetMapping("/findByPage")
	public Response<?> findBankDetailsByPage(@RequestParam Optional<Integer> pageNo,
			@RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortByBankName) {
		Response<?> findBankDetailsByPage = bankService.findBankDetailsByPage(pageNo, pageSize, sortByBankName);
		return findBankDetailsByPage;

	}

	@GetMapping("/sortBankByCode")
	public Response<?> sortBankDetailsByCode() {
		Response<?> sortBankDetailsByCode = bankService.sortBankDetailsByCode();

		return sortBankDetailsByCode;
	}

}
