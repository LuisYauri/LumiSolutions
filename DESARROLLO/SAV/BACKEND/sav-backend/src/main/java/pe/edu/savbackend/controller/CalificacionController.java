package pe.edu.savbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.CalificacionDto;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//registra una calificacion (estrellas)
	public CalificacionDto registerUpdate(@RequestBody CalificacionDto er) {
		return CalificacionDto.builder().build();
	}

}