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
	
	private ArrayList<String> respuestas;
	
	private String correcta;

	
	
	
	
	public Pregunta(String tema, String pregunta, ArrayList<String> respuestas, String correcta) {
		this.tema = tema;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.correcta = correcta;
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

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}

	public String getCorrecta() {
		return correcta;
	}

	public void setCorrecta(String correcta) {
		this.correcta = correcta;
	}
	
	
	
	
}
