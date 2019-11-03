package pe.edu.savbackend.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.service.pregunta.PreguntaService;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

	@Autowired
	PreguntaService preguntaService;
	
	// comprobar pregunta
	@PostMapping(value = "/{idPregunta}/comprobar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Boolean> comprobarPregunta(@PathVariable Integer idPregunta, @RequestBody String respuesta) {
		//System.out.println("idPregunta: " + idPregunta);
		//System.out.println("resp: " + respuesta);
		return preguntaService.getRespuesta(idPregunta, respuesta);
	}

}