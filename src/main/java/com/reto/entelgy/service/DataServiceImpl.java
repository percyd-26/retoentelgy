package com.reto.entelgy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reto.entelgy.converter.DataConverter;
import com.reto.entelgy.dto.DataDTO;
import com.reto.entelgy.dto.ContentDataDTO;
import com.reto.entelgy.model.Data;
import com.reto.entelgy.repository.DataRepositoryExternal;

@Service("servicio")
public class DataServiceImpl implements DataService {
	@Autowired
	@Qualifier("repository")
	private DataRepositoryExternal repositorio;
	
	@Autowired
	@Qualifier("converter")
	private DataConverter convertidor;
	
	@Override
	public ContentDataDTO getData() {
		List<String> list = new ArrayList<>();
		List<DataDTO> dtoList = repositorio.getData();
		List<Data> dataList =convertidor.convertDataList(dtoList);
		dataList.forEach(dt->{
			list.add(dt.getPostId() + "|" + dt.getId() + "|" + dt.getEmail());
		});
		
		ContentDataDTO data = new ContentDataDTO(list);
		return data;
	}

}
