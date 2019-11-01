package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.entity.Criterio;
import pe.edu.savbackend.entity.Area;
import pe.edu.savbackend.entity.Calificacion;
import pe.edu.savbackend.entity.Contenido;
import pe.edu.savbackend.entity.Docente;
import pe.edu.savbackend.entity.Estudiante;
import pe.edu.savbackend.entity.Grupo;
import pe.edu.savbackend.entity.MaestraDetalle;
import pe.edu.savbackend.entity.Persona;
import pe.edu.savbackend.entity.Recurso;
import pe.edu.savbackend.entity.Subcontenido;
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
	
}