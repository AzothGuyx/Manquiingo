package com.proyecto.app;

import org.junit.jupiter.api.Test;	
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;	
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto.app.models.dao.PreguntaDao;
import com.proyecto.app.models.documents.Pregunta;

import reactor.core.publisher.Mono;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PreguntaDaoTests {
	
	@Autowired
	PreguntaDao preguntaDao;
	
	@Test
	public void crearPreguntaTest() {
		
		ArrayList<String> b = new ArrayList<String>();
		b.add("Cartagena");
		b.add("Barrancabermeja");
		b.add("Medellin");
		
		Pregunta nuevaPregunta = new Pregunta("2", "Geografia", "Cual es la capital de Antioquia?", b, "Medellin");
		preguntaDao.save(nuevaPregunta).subscribe();
	}
	
	@Test
	public void buscarPreguntaTest() {
		
		Mono<Pregunta> preguntaBuscada = preguntaDao.findById("2");
		assertEquals(preguntaBuscada.block().getCorrecta(), "Medellin");
		
	}
	
	@Test 
	public void eliminarPreguntaTest() {
		
		Mono<Pregunta> preguntaEliminada = preguntaDao.findById("2");
		assertNotNull(preguntaEliminada.block().getId());
	}

}
