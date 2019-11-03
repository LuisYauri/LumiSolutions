package pe.edu.savbackend.service.recurso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.ComentarioDao;
import pe.edu.savbackend.dao.EvaluacionDao;
import pe.edu.savbackend.dao.RecursoDao;
import pe.edu.savbackend.domain.comentario.ComentarioResponse;
import pe.edu.savbackend.domain.comentario.RecursoDto;
import pe.edu.savbackend.domain.tarea.TareaDto;
import pe.edu.savbackend.entity.Recurso;

@Service
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	private RecursoDao recursoDao;
	@Autowired
	private ComentarioDao comentarioDao;

	@Override
	public RecursoDto obtenerRecursoPorId(Integer idRecurso, Integer idEstudiante) {
		//contar las tareas formatear la fecha 	
		RecursoDto recursoDto = recursoDao.obtenerPorId(idRecurso, idEstudiante);
		List<ComentarioResponse> lsComentarios = comentarioDao.obtenerListaComentarios(idRecurso);
		recursoDto.setLsComentarios(lsComentarios);

		return recursoDto;
	}

	public List<ComentarioResponse> ob(Integer idRecurso) {
		//contar las tareas formatear la fecha 	
		return comentarioDao.obtenerListaComentarios(idRecurso);
	}

	public List<RecursoDto> filtrarPorIdSubcontenido(Integer idSubContenido) {
		//contar las tareas formatear la fecha 	
		List<RecursoDto> listaRecursosDto = recursoDao.filtrarPorIdSubcontenido(idSubContenido);

		listaRecursosDto.forEach(recursoDto -> {
			List<ComentarioResponse> lsComentarios = comentarioDao.obtenerListaComentarios(recursoDto.getIdRecurso());
			recursoDto.setLsComentarios(lsComentarios);
		});

		return listaRecursosDto;
	}

}
