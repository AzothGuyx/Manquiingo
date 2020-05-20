package com.proyecto.app.controllers;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.app.models.dao.PartidaDao;
import com.proyecto.app.models.dao.PreguntaDao;
import com.proyecto.app.models.documents.Partida;
import com.proyecto.app.models.documents.Pregunta;

import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/partidas")
public class PartidaRestController {

	@Autowired
	private PartidaDao partidaDao;
	
	@Autowired
	private PreguntaDao preguntaDao;
	
	@PostMapping("/crearpartida/{puntaje}")
	public Flux<Partida> crearPartida(@PathVariable int puntaje){
		return null; 
	}
	
	
	@GetMapping("/iniciar/{tema}")
	public Flux<Pregunta> iniciarPartida(@PathVariable String tema){
		Flux<Pregunta> preguntas= preguntaDao.findByTema(tema).delayElements(Duration.ofSeconds(10));
		
		return preguntas;
	}
	
}
