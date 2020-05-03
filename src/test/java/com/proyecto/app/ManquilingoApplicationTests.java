package com.proyecto.app;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto.app.models.dao.PartidaDao;
import com.proyecto.app.models.documents.Partida;

import reactor.core.publisher.Mono;


@RunWith(SpringRunner.class)
@SpringBootTest
class ManquilingoApplicationTests {
	
	@Autowired
	PartidaDao partidaDao;
	
	@Test
	public void crearPartidaTest() {
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Carlos");
		a.add("Maria");
		a.add("Juan");
		
		partidaDao.save(new Partida("3", 10, a, "Sistemas")).subscribe();
	}
	
	@Test
	public void buscarPartidaTest() {
		
		Mono<Partida> partidaBuscada = partidaDao.findById("3");
		assertEquals(partidaBuscada.block().getTema(), "Sistemas");
	}
	
	@Test 
	public void eliminarPartidaTest() {
			
		partidaDao.deleteById("2");
		Mono<Partida> partidaBorrada = partidaDao.findById("2");
		assertNotEquals(partidaBorrada.block().getId(), "2");	
	}

	
	
	@Test
	void contextLoads() {
	}

}
