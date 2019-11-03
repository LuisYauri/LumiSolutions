package pe.edu.savbackend.service.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.ComentarioDao;
import pe.edu.savbackend.dao.RecursoDao;
import pe.edu.savbackend.domain.comentario.ComentarioResponse;
import pe.edu.savbackend.domain.comentario.RecursoDto;
import pe.edu.savbackend.service.comentario.ComentarioService;

@Service
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	private RecursoDao recursoDao;
	@Autowired
	private ComentarioService comentarioService;

	@Override
	public RecursoDto obtenerRecursoPorId(Integer idRecurso, Integer idEstudiante) {
		//contar las tareas formatear la fecha 	
		RecursoDto recursoDto = recursoDao.obtenerPorId(idRecurso, idEstudiante);
		List<ComentarioResponse> lsComentarios = comentarioService.obtenerListaComentarios(idRecurso);
		recursoDto.setLsComentarios(lsComentarios);

		return recursoDto;
	}

	public List<RecursoDto> filtrarPorIdSubcontenido(Integer idSubContenido) {
		//contar las tareas formatear la fecha 	
		List<RecursoDto> listaRecursosDto = recursoDao.filtrarPorIdSubcontenido(idSubContenido);

		listaRecursosDto.forEach(recursoDto -> {
			List<ComentarioResponse> lsComentarios = comentarioService.obtenerListaComentarios(recursoDto.getIdRecurso());
			recursoDto.setLsComentarios(lsComentarios);
		});

		return listaRecursosDto;
	}

}
