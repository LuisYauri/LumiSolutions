package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.entity.Historial;
import pe.edu.savbackend.entity.Alternativa;
import pe.edu.savbackend.entity.Comentario;
import pe.edu.savbackend.entity.Docente;
import pe.edu.savbackend.entity.Estudiante;
import pe.edu.savbackend.entity.EstudianteEvaluacion;
import pe.edu.savbackend.entity.EvaluacionDetalle;
import pe.edu.savbackend.entity.Grupo;
import pe.edu.savbackend.entity.Matricula;
import pe.edu.savbackend.entity.Persona;
import pe.edu.savbackend.entity.Pregunta;
import pe.edu.savbackend.entity.TablaMaestra;
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

	@Autowired
	MatriculaDao matriculaDao;
	@RequestMapping("matriculas")
	public List<Matricula> getMatriculas() {
		return matriculaDao.findAll();
	}

	@Autowired
	ComentarioDao comentarioDao;
	@RequestMapping("comentarios")
	public List<Comentario> getComentarios() {
		return comentarioDao.findAll();
	}

	@Autowired
	AlternativaDao alternativaDao;
	@RequestMapping("alternativas")
	public List<Alternativa> getAlternativas() {
		return alternativaDao.findAll();
	}

	@Autowired
	PreguntaDao preguntaDao;
	@RequestMapping("preguntas")
	public List<Pregunta> getPreguntas() {
		return preguntaDao.findAll();
	}

	@Autowired
	EstudianteEvaluacionDao estudianteEvaluacionDao;
	@RequestMapping("estudianteEvaluaciones")
	public List<EstudianteEvaluacion> getEstudianteEvaluaciones() {
		return estudianteEvaluacionDao.findAll();
	}

	@Autowired
	HistorialDao historialDao;
	@RequestMapping("historiales")
	public List<Historial> getHistoriales() {
		return historialDao.findAll();
	}

	@Autowired
	EvaluacionDetalleDao evaluacionDetalleDao;
	@RequestMapping("evaluacionDetalles")
	public List<EvaluacionDetalle> getEvaluacionDetalles() {
		return evaluacionDetalleDao.findAll();
  }
  
	@Autowired
	TablaMaestraDao tablaMaestraDao;
	@RequestMapping("tablas-maestras")
	public List<TablaMaestra> getTablaMaestra() {
		return tablaMaestraDao.findAll();
	}
}