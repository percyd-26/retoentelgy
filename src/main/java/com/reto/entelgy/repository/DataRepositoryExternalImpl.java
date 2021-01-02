package com.reto.entelgy.repository;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.reto.entelgy.constants.Constants;
import com.reto.entelgy.dto.DataDTO;

@Repository("repository")
public class DataRepositoryExternalImpl implements DataRepositoryExternal {
	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public List<DataDTO> getData() {
		try {
	        	RequestEntity<Void> requestEntity = RequestEntity.get(new URI(Constants.RESOURCE_EXTERNAL)).build();
	            ResponseEntity<DataDTO[]> response = restTemplate.exchange(requestEntity, DataDTO[].class);
	            List<DataDTO> datos= Arrays.asList(response.getBody());
	            return datos;
		 	}catch (Exception ex) {
	        	System.out.println(ex.getMessage());
	        	return null;
	        }
	}

}
