package pe.edu.savbackend.controller.profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.service.matricula.MatriculaService;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("matricula")
public class MatriculaController {


	@Autowired
	MatriculaService matriculaService;
	
	@PostMapping(value = "/aula/{idAula}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> matricular(@PathVariable Integer idAula, @RequestBody Integer[] idEstudiantes) {
		matriculaService.matricular(idAula, idEstudiantes);
		return ResponseEntity.ok("Alumnos matriculados con exito");
	}

	@DeleteMapping(value = "/{idEstudiante}/{idAula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarAlumnoDeMatricula(@PathVariable Integer idEstudiante, @PathVariable Integer idAula) {
		System.out.println("idEstudiante: " + idEstudiante);
		System.out.println("idAula: " + idAula);
		matriculaService.eliminarAlumnoDeMatricula(idEstudiante, idAula);
	}
	
}