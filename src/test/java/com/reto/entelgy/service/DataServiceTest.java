package com.reto.entelgy.service;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.reto.entelgy.dto.ContentDataDTO;
import com.reto.entelgy.dto.DataDTO;
import com.reto.entelgy.repository.DataRepositoryExternal;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceTest {
	@MockBean
	@Qualifier("repository")
	private DataRepositoryExternal repositorio;
	
	@Autowired
	@Qualifier("servicio")
	DataService service;
	
	@Test
	public void testGetData() {
		List<DataDTO> dtos = new ArrayList<DataDTO>();
		DataDTO dto = new DataDTO();
		dto.setPostId(1);
		dto.setId(2);
		dto.setEmail(".com");
		dtos.add(dto);
		
		List<String> lista = new ArrayList<String>();
		String str = dto.getPostId() + "|" + dto.getId() + "|" + dto.getEmail();
		lista.add(str);
		ContentDataDTO content = new ContentDataDTO(lista);
		
		given(this.repositorio.getData()).willReturn(dtos);
		
		assertArrayEquals(content.getData().toArray(),this.service.getData().getData().toArray());
	}
}
