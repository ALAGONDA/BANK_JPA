package com.example.demo.response;

import org.springframework.http.HttpStatus;

public class Response<T> {
	private T data;

	private String msg;

	private HttpStatus httpStatus;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(T data, String msg, HttpStatus httpStatus) {
		super();
		this.data = data;
		this.msg = msg;
		this.httpStatus = httpStatus;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "Response [data=" + data + ", msg=" + msg + ", httpStatus=" + httpStatus + "]";
	}

}
