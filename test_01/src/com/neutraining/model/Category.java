package com.neutraining.model;

public class Category {
	private String cid;
	private String cname;
	
	public Category() {}
	
	public Category(String cname) {
		super();
		this.cname = cname;
	}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
