package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Bank;
import com.example.demo.repo.BankRepo;

@Repository
public class BankDao {

	@Autowired
	private BankRepo bankRepo;

	public Bank insert(Bank bank) {

		Bank save = bankRepo.save(bank);

		return save;

	}

	public int update(Bank bank) {

		int count = bankRepo.updateByBankIfscCode(bank.getBankname(), bank.getAddress(), bank.getBranch(),
				bank.getIfsccode());
		if (count > 0) {
			return count;
		}
		return -1;

	}

	public Bank updateData(Bank bank) {
		Optional<Bank> findById = bankRepo.findById(bank.getBankid());
		if (findById.isPresent()) {
			return bankRepo.save(bank);
		}
		return null;
	}

	public List<Bank> getBank() {
		return bankRepo.findAll();

	}

	public void deleteById(int userid) {
		bankRepo.deleteById(userid);

	}

	public Page<Bank> findBankDetailsByPage(Optional<Integer> pageNo, Optional<Integer> pageSize,
			Optional<String> sortByBankName) {
		return bankRepo.findAll(
				PageRequest.of(pageNo.orElse(0), pageSize.orElse(0), Direction.ASC, sortByBankName.orElse("id")));

	}

	public List<Bank> sortBankDetailsByCode() {

		return bankRepo.findAllSortedByIfscCode();

	}

}
