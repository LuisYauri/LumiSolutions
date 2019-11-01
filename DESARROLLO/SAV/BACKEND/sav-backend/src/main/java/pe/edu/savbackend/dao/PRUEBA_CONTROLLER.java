package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.entity.Docente;
import pe.edu.savbackend.entity.Estudiante;
import pe.edu.savbackend.entity.Grupo;
import pe.edu.savbackend.entity.Persona;
import pe.edu.savbackend.entity.Usuario;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/prueba/")
public class PRUEBA_CONTROLLER {

	@Autowired
	GrupoDao grupoDao;
	@RequestMapping("grupos")
	public List<Grupo> getGrupos() {
		return grupoDao.findAll();
	}

	@Autowired
	DocenteDao docenteDao;
	@RequestMapping("docentes")
	public List<Docente> getDocentes() {
		return docenteDao.findAll();
	}
	
	@Autowired
	EstudianteDao estudianteDao;
	@RequestMapping("estudiantes")
	public List<Estudiante> getEstudiantes() {
		return estudianteDao.findAll();
	}
	
	@Autowired
	PersonaDao personasDao;
	@RequestMapping("personas")
	public List<Persona> getPersonas() {
		return personasDao.findAll();
	}
	
	@Autowired
	UsuarioDao usuariosDao;
	@RequestMapping("usuarios")
	public List<Usuario> getUsuario() {
		return usuariosDao.findAll();
	}
}