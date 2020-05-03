package com.proyecto.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
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
		
		partidaDao.save(new Partida("2", 10, a, "Sistemas")).subscribe();
	}
	
	@Test
	public void buscarPartidaTest() {
		
		Mono<Partida> partidaBuscada = partidaDao.findById("2");
		assertEquals(partidaBuscada.block().getTema(), "Sistemas");
	}

	
	
	@Test
	void contextLoads() {
	}

}
