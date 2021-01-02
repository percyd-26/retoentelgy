package com.reto.entelgy.dto;

import java.util.List;

public class ContentDataDTO {
	private List<String> data;

	public ContentDataDTO() {
		
	}

	public ContentDataDTO(List<String> data) {
		this.data = data;
	}
	
	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
}
