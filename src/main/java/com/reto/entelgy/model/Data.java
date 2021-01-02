package com.reto.entelgy.model;

import com.reto.entelgy.dto.DataDTO;

public class Data {
	private Integer postId;
	private Integer id;
	private String email;
	
	public Data(DataDTO dto) {
		this.postId = dto.getPostId();
		this.id = dto.getId();
		this.email = dto.getEmail();
	}
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
