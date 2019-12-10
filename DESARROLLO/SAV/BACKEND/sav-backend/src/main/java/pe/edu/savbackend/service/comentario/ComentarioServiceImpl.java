package pe.edu.savbackend.service.comentario;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.ComentarioDao;
import pe.edu.savbackend.domain.comentario.ComentarioResponse;
import pe.edu.savbackend.entity.Comentario;

@Service
public class ComentarioServiceImpl implements ComentarioService {
	
	@Autowired
	ComentarioDao comentarioDao;
	
	@Override
	public Comentario registrarComentario(Comentario comentario) {
		comentario.setFecha(LocalDateTime.now());
		System.out.println(comentario.getIdComentario());
		if(comentario.getIdComentario() != null) {
			throw new RuntimeException("No puede editar su comentario");
		}else {
			if(comentario.getDescripcion() == null) {
				throw new RuntimeException("Debe escribir un comentario");
			}else {
				comentario.setIdComentario(comentarioDao.nextId());
				return comentarioDao.save(comentario);
			}
		}
		
	}

	public List<ComentarioResponse> listaComentariosPorIdRecurso(Integer idRecurso)
	{
		List<ComentarioResponse> listComentarioResponse = comentarioDao.obtenerListaComentarios(idRecurso);
		listComentarioResponse.forEach( comentarioResponse -> {
			comentarioResponse.setInicialesEstudiante(
				comentarioResponse.getNombreEstudiante().substring(0, 1).toUpperCase() + 
				comentarioResponse.getApellidoPaternoEstudiante().substring(0, 1).toUpperCase()
			);
		});
		return listComentarioResponse;
	}




	

}
