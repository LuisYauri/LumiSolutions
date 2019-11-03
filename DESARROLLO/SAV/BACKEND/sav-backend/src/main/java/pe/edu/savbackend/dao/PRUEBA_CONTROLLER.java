package pe.edu.savbackend.dao;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.entity.Criterio;
import pe.edu.savbackend.entity.Area;
import pe.edu.savbackend.entity.Calificacion;
import pe.edu.savbackend.entity.Contenido;
import pe.edu.savbackend.entity.Historial;
import pe.edu.savbackend.domain.tarea.Tarea;
import pe.edu.savbackend.entity.Alternativa;
import pe.edu.savbackend.entity.Comentario;

import pe.edu.savbackend.entity.Docente;
import pe.edu.savbackend.entity.Estudiante;
import pe.edu.savbackend.entity.EstudianteEvaluacion;
import pe.edu.savbackend.entity.EvaluacionDetalle;
import pe.edu.savbackend.entity.Grupo;

import pe.edu.savbackend.entity.MaestraDetalle;
import pe.edu.savbackend.entity.Recurso;
import pe.edu.savbackend.entity.Subcontenido;
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

	@Autowired
	AreaDao areaDao;

	@RequestMapping("areas")
	public List<Area> getArea() {
		return areaDao.findAll();
	}

	@Autowired
	CriterioDao criterioDao;

	@RequestMapping("criterios")
	public List<Criterio> getCriterio() {
		return criterioDao.findAll();
	}

	@Autowired
	ContenidoDao contenidoDao;

	@RequestMapping("contenidos")
	public List<Contenido> getContenido() {
		return contenidoDao.findAll();
	}

	@Autowired
	SubcontenidoDao subcontenidoDao;

	@RequestMapping("subcontenidos")
	public List<Subcontenido> getSubcontenido() {
		return subcontenidoDao.findAll();
	}

	@Autowired
	RecursoDao recursoDao;

	@RequestMapping("recursos")
	public List<Recurso> getRecurso() {
		return recursoDao.findAll();
	}

	@Autowired
	MaestraDetalleDao maestraDetalleDao;

	@RequestMapping("maestra-detalles")
	public List<MaestraDetalle> getMaestraDetalle() {
		return maestraDetalleDao.findAll();
	}

	@Autowired
	CalificacionDao calificacionDao;

	@RequestMapping("calificaciones")
	public List<Calificacion> getCalificacion() {
		return calificacionDao.findAll();
	}

	@Autowired
	EvaluacionDao evaluDao;

//	@RequestMapping("evas/{idEstudiante}")
//	public List<Tarea> getTareasEval(@PathVariable Integer idEstudiante) {
//		return evaluDao.ejemplo(idEstudiante);
//	}
	
}