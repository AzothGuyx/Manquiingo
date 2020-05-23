package com.proyecto.app.models.documents;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "preguntas")
public class Pregunta {

	@Id
	private String id;
	
	private String tema;
	
	private String pregunta;
	
	private ArrayList<Respuesta> respuestas;
	
	
	public Pregunta() {}
		
	public Pregunta(String tema, String pregunta, ArrayList<Respuesta> respuestas) {
		this.tema = tema;
		this.pregunta = pregunta;
		this.respuestas = respuestas;

	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}


	
	
	
	
}
