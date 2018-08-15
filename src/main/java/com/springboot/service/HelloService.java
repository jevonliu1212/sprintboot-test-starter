package com.springboot.service;

public class HelloService {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
  public void hi(){
	  System.out.println("hi==========="+this.msg);
  }
}
