package com.proyecto.app.models.daoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.proyecto.app.controllers.JugadorController;
import com.proyecto.app.models.dao.JugadorDao;
import com.proyecto.app.models.documents.Jugador;

import reactor.core.publisher.Mono;


public class JugadorDaoTest {

	@Mock
	private JugadorController controller;
	
	@Mock
	private JugadorDao dao;
	
	
	
	@Test
	public void testController() {
		Jugador jugador= new Jugador("Juan");
		dao.save(jugador).subscribe();
		Mono<Jugador> nombre = dao.findByNombre("juan");
		assertThat(nombre).isNotNull();
	}
	 
	
	
}
