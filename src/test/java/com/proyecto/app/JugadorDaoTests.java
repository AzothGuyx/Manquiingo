package com.proyecto.app;

import org.junit.jupiter.api.Test;	
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;	
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto.app.models.dao.JugadorDao;
import com.proyecto.app.models.documents.Jugador;

import reactor.core.publisher.Mono;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JugadorDaoTests {

	@Autowired
	JugadorDao jugadorDao;
	
	@Test
	public void crearJugadorTest() {
		
		jugadorDao.save(new Jugador("4", "Wilfri", 20)).subscribe();
	}
	
	@Test
	public void buscarJugadorTest() {
		
		Mono<Jugador> jugadorBuscado = jugadorDao.findById("4");
		assertEquals(jugadorBuscado.block().getNombre(), "Wilfri");
	}
	
	@Test
	public void eliminarJugador() {
		
		Mono<Jugador> jugadorEliminado = jugadorDao.findById("4");
		assertNotNull(jugadorEliminado.block().getId());
	}
}
