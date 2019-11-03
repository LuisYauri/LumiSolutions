package pe.edu.savbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.entity.Comentario;
import pe.edu.savbackend.service.comentario.ComentarioService;

@RestController
@RequestMapping("/comentario")
public class CalificacionController {

	
	@Autowired
	ComentarioService comentarioService;
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//registra una calificacion (estrellas)
	public Comentario registerUpdate(@RequestBody Comentario comentario) {
		return comentarioService.registrarComentario(comentario);
	}

}