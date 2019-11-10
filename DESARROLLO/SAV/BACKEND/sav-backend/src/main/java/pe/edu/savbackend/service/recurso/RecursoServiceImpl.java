package pe.edu.savbackend.service.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.RecursoDao;
import pe.edu.savbackend.domain.comentario.ComentarioResponse;
import pe.edu.savbackend.domain.comentario.RecursoDto;
import pe.edu.savbackend.service.calificaciones.CalificacionService;
import pe.edu.savbackend.service.comentario.ComentarioService;

@Service
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	private RecursoDao recursoDao;
	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private CalificacionService calificacionService;
	
	@Override
	public RecursoDto obtenerRecursoPorId(Integer idRecurso, Integer idEstudiante) {

		Integer calificacionEstudiante = calificacionService.obtenerCalificacionPorEstudiante(idRecurso, idEstudiante);
		Double calificacionPromedio = calificacionService.obtenerCalificacionPromedio(idRecurso);
		
		calificacionPromedio = Math.floor(calificacionPromedio*10)/10;
		
		RecursoDto recursoDto = recursoDao.obtenerPorId(idRecurso);
		recursoDto.setPromedioCalificacion(calificacionPromedio);
		recursoDto.setAlumnoCalificacion((calificacionEstudiante== null)?0:calificacionEstudiante);
		return recursoDto;
	}

	public List<RecursoDto> filtrarPorIdSubcontenido(Integer idSubContenido) {
		//contar las tareas formatear la fecha 	
		List<RecursoDto> listaRecursosDto = recursoDao.filtrarPorIdSubcontenido(idSubContenido);

		listaRecursosDto.forEach(recursoDto -> {
			List<ComentarioResponse> lsComentarios = comentarioService.listaComentariosPorIdRecurso(recursoDto.getIdRecurso());
			recursoDto.setLsComentarios(lsComentarios);
		});

		return listaRecursosDto;
	}

}
