package pe.edu.savbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.entity.Calificacion;
import pe.edu.savbackend.service.calificaciones.CalificacionService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/calificaciones")
public class CalificacionController {

	
	@Autowired
	CalificacionService calificacionService;
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//registra una calificacion (estrellas)
	public Double registrarCalificacion(@RequestBody Calificacion calificacion) {
		
		return calificacionService.registrarCalificacion(calificacion);
	}

}