package com.reto.entelgy.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.reto.entelgy.dto.DataDTO;
import com.reto.entelgy.repository.DataRepositoryExternal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataControllerTest {
	@MockBean
	@Qualifier("repository")
	private DataRepositoryExternal repositorio;
	
	@Autowired
	DataController controlador;
	
	@Test
	public void testPostData() {
		List<DataDTO> dtos = new ArrayList<DataDTO>();
		DataDTO dto = new DataDTO();
		dto.setPostId(22);
		dto.setId(55);
		dto.setEmail(".com.pe");
		dtos.add(dto);
		
		given(this.repositorio.getData()).willReturn(dtos);
		assertNotNull(controlador.postData());
		assertEquals(22 + "|" + 55 + "|" + ".com.pe",controlador.postData().getData().get(0));
	}
}
