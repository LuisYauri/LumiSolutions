package pe.edu.savbackend.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import pe.edu.savbackend.service.pregunta.PreguntaService;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

	@Autowired
	PreguntaService preguntaService;
	
	// comprobar pregunta
	@PostMapping(value = "/{idPregunta}/comprobar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Boolean> comprobarPregunta(@PathVariable Integer idPregunta, @RequestBody RespuestaBody respuesta) {
		System.out.println("idPregunta: " + idPregunta);
		System.out.println("resp: " + respuesta.getRespuesta());
		return preguntaService.getRespuesta(idPregunta, respuesta.getRespuesta());
	}

}

@Data
class RespuestaBody {
	private String respuesta;
}