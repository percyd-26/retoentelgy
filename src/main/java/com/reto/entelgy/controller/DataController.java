package com.reto.entelgy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.entelgy.constants.Constants;
import com.reto.entelgy.dto.ContentDataDTO;
import com.reto.entelgy.service.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(Constants.API_VERSION)
public class DataController {
	@Autowired
	@Qualifier("servicio")
	DataService service;
	
	@PostMapping(Constants.RESOURCE)
	public ContentDataDTO postData(){
		ContentDataDTO data = service.getData();
		return data;
	} 
}
