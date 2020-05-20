package com.proyecto.app.models.dao;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.proyecto.app.models.documents.Pregunta;
import reactor.core.publisher.Flux;


public interface PreguntaDao extends ReactiveMongoRepository<Pregunta,String>{
	
	Flux<Pregunta> findByTema(String tema);
	
	

}
