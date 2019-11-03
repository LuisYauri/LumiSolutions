package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.tarea.PreguntaDto;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

	// comprobar pregunta
	@PostMapping(value = "/{idPregunta}/comprobar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean comprobarPregunta(@RequestBody PreguntaDto er) {
		return true;
	}

}