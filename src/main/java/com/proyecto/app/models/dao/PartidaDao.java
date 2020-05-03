package com.proyecto.app.models.dao;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.proyecto.app.models.documents.Partida;

public interface PartidaDao extends ReactiveMongoRepository<Partida, String>{


}
