package pe.edu.savbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.comentario.ComentarioResponse;
import pe.edu.savbackend.entity.Comentario;
import pe.edu.savbackend.service.comentario.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
	
	@Autowired
	ComentarioService comentarioService;

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Comentario register(@RequestBody Comentario comentario) {
		return comentarioService.registrarComentario(comentario);
	}

	@RequestMapping("")//?idRecurso={idRecurso}
	public List<ComentarioResponse> obtenerListaComentarios(@RequestParam(required = false) Integer idRecurso) {
		return comentarioService.obtenerListaComentarios(idRecurso); // devolver un recurso con lista de alumnos
	}

}