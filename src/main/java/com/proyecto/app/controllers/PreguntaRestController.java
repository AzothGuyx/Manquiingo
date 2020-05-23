package com.proyecto.app.controllers;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.app.models.documents.Pregunta;

import reactor.core.publisher.Flux;

import com.proyecto.app.models.dao.PreguntaDao;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PreguntaRestController {
	
	@Autowired
	private PreguntaDao preguntaDao;
		
	@GetMapping("/pregunta")
	public Flux<Pregunta> index(){
		return preguntaDao.findAll()
				.delayElements(Duration.ofMillis(100));

	}
	
	

}
