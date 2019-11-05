package pe.edu.savbackend.service.comentario;

import java.util.List;

import pe.edu.savbackend.domain.comentario.ComentarioResponse;
import pe.edu.savbackend.entity.Comentario;

public interface ComentarioService {

	Comentario registrarComentario(Comentario comentario);

	List<ComentarioResponse> listaComentariosPorIdRecurso(Integer idRecurso);
}
