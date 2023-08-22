package com.example.demo.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankid;

	private String bankname;

	private String ifsccode;

	private String branch;

	private String address;

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createtime;

	@UpdateTimestamp
	private Timestamp updatetime;

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int bankid, String bankname, String ifsccode, String branch, String address, Timestamp createtime,
			Timestamp updatetime) {
		super();
		this.bankid = bankid;
		this.bankname = bankname;
		this.ifsccode = ifsccode;
		this.branch = branch;
		this.address = address;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	public int getBankid() {
		return bankid;
	}

	public void setBankid(int bankid) {
		this.bankid = bankid;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "Bank [bankid=" + bankid + ", bankname=" + bankname + ", ifsccode=" + ifsccode + ", branch=" + branch
				+ ", address=" + address + ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
	}

}
