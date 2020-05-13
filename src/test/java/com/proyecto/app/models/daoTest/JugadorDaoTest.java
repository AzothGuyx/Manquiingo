package com.proyecto.app.models.daoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto.app.controllers.JugadorController;
import com.proyecto.app.models.dao.JugadorDao;
import com.proyecto.app.models.documents.Jugador;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
public class JugadorDaoTest {

	@Mock
	private JugadorController controller;
	
	@Autowired
	private JugadorDao dao;
	
	
	
	@Test
	public void testController() {
		Jugador jugador= new Jugador("Juan");
		dao.save(jugador).subscribe();
		Mono<Jugador> nombre = dao.findByNombre("juan");
		assertThat(nombre).isNotNull();
	}
	 
	
	
}
