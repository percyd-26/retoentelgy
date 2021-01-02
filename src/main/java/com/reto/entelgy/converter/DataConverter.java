package com.reto.entelgy.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.reto.entelgy.dto.DataDTO;
import com.reto.entelgy.model.*;

@Component("converter")
public class DataConverter {
	public List<Data> convertDataList(List<DataDTO> dtos){
		List<Data> datos = new ArrayList<>();
		for (DataDTO dto : dtos) {
			datos.add(new Data(dto));			
		}
		return datos;
	}
}
