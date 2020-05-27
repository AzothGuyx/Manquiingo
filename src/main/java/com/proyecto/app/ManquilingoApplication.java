package com.proyecto.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.app.models.dao.PartidaDao;
import com.proyecto.app.models.dao.PreguntaDao;

import com.proyecto.app.models.documents.Partida;
import com.proyecto.app.models.documents.Pregunta;
import com.proyecto.app.models.documents.Respuesta;

//import reactor.core.publisher.Flux;

@SpringBootApplication
public class ManquilingoApplication implements CommandLineRunner{

	@Autowired
	private PartidaDao partidaDao;
	
	@Autowired
	private PreguntaDao preguntaDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ManquilingoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Partida con tema de programación
		crearPartida("Programación", 0);
		
		//Prueba de conocimiento CSS
		crearPregunta("Programación", "¿Qué significa CSS?", "Cascading Style Sheets", "Creative Style Sheets", "Colorful Style Sheets", "Computer Style Sheets");
		crearPregunta("Programación", "¿Cuál es el HTML correcto para referenciar a una hoja de estilo externa?", "<link rel=\"stylesheet\" type=\"text/css\" href=\"mystyle.css\">", "<style src=\"mystyle.css\">", "<stylesheet>mystyle.css</stylesheet>");
		crearPregunta("Programación", "¿Cuál es el lugar correcto para colocar la referencia a una hoja de estilo externa dentro de un documento HTML?", "En la sección <head>", "En la sección <body>", "Al final del documento");
		crearPregunta("Programación", "¿Qué etiqueta HTML se utiliza para definir una hoja de estilo interna?", "<style>", "<script>", "<css>");
		crearPregunta("Programación", "¿Qué atributo HTML se usa para definir los estilos de línea?", "style", "styles", "font", "class");
		
		//Prueba de conocimiento JavaScript
		crearPregunta("Programación", "¿Dentro de qué elemento HTML ponemos el JavaScript?", "<script>", "<javascript>", "<js>", "<scripting>");
		crearPregunta("Programación", "¿Dónde es el lugar correcto para insertar código JavaScript?", "Tanto la sección <head> como la sección <body> son correctas", "La sección <body>", "La sección <head>");
		crearPregunta("Programación", "¿Cuál es la sintaxis correcta para referencia a un script externo llamado \"xxx.js\"?", "<script src=\"xxx.js\">", "<script name=\"xxx.js\">", "<script href=\"xxx.js\">");
		crearPregunta("Programación", "El archivo JavaScript externo debe contener la etiqueta <script>.", "Si", "No", "Es indiferente");
		crearPregunta("Programación", "¿Cómo se imprime \"Hello World\" en un cuadro de diálogo?", "alert(\"Hello World\");", "alertBox(\"Hello World\");", "msgBox(\"Hello World\");", "msg(\"Hello World\");");
		
		//Prueba de conocimiento HTML
		crearPregunta("Programación", "¿Qué significa HTML?", "Hyper Text Markup Language", "Hyperlinks and Text Markup Language", "Home Tool Markup Language");
		crearPregunta("Programación", "¿Quién está haciendo los estándares web?", "The World Wide Web Consortium", "Mozilla", "Microsoft", "Google");
		crearPregunta("Programación", "Elija el elemento HTML correcto para el encabezado más grande:", "<h1>", "<head>", "<h6>", "<heading>");
		crearPregunta("Programación", "¿Cuál es el elemento HTML correcto para insertar un salto de línea?", "<br>", "<break>", "<lb>");
		crearPregunta("Programación", "Elija el elemento HTML correcto para definir el texto importante", "<strong>", "<i>", "<b>", "<important>");
		
		//Prueba de conocimiento SQL
		crearPregunta("Programación", "¿Qué significa SQL?", "Structured Query Language", "Strong Question Language", "Structured Question Language");
		crearPregunta("Programación", "¿Qué declaración SQL se utiliza para extraer datos de una base de datos?", "SELECT", "GET", "OPEN", "EXTRACT");
		crearPregunta("Programación", "¿Qué declaración SQL se usa para actualizar datos en una base de datos?", "UPDATE", "SAVE AS", "SAVE", "MODIFY");
		crearPregunta("Programación", "¿Qué declaración SQL se utiliza para eliminar datos de una base de datos?", "DELETE", "REMOVE", "COLLAPSE");
		crearPregunta("Programación", "¿Qué declaración SQL se usa para insertar nuevos datos en una base de datos?", "INSERT INTO", "ADD RECORD", "INSERT NEW", "ADD NEW");
				
	}
	
	public void crearPregunta(String tema, String pregunta, String opcionCorrecta, String opcion2, String opcion3, String opcion4) {
		
		ArrayList<Respuesta> opciones = new ArrayList<Respuesta>();
		opciones.add(new Respuesta(opcion2, false));
		opciones.add(new Respuesta(opcion3, false));
		opciones.add(new Respuesta(opcionCorrecta, true));
		opciones.add(new Respuesta(opcion4, false));
		
		preguntaDao.save(new Pregunta(tema, pregunta, opciones)).subscribe();
		
	}
	
	public void crearPregunta(String tema, String pregunta, String opcionCorrecta, String opcion2, String opcion3) {
		
		ArrayList<Respuesta> opciones = new ArrayList<Respuesta>();
		opciones.add(new Respuesta(opcion2, false));
		opciones.add(new Respuesta(opcion3, false));
		opciones.add(new Respuesta(opcionCorrecta, true));
				
		preguntaDao.save(new Pregunta(tema, pregunta, opciones)).subscribe();
	}
	
	public void crearPartida(String tema, int puntaje) {
	
		ArrayList<String> a = new ArrayList<String>();
		a.add("Carlos");
		a.add("Maria");
		a.add("Juan");
		partidaDao.save(new Partida(puntaje, a, tema)).subscribe();
	}
}
