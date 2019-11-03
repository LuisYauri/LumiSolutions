package pe.edu.savbackend.service.comentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.ComentarioDao;
import pe.edu.savbackend.entity.Comentario;

@Service
public class ComentarioServiceImpl implements ComentarioService {
	
	@Autowired
	ComentarioDao comentarioDao;
	
	@Override
	public Comentario registrarComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		System.out.println(comentario.getId());
		if(comentario.getId() != null) {
			throw new RuntimeException("No puede editar su comentario");
		}else {
			if(comentario.getDescripcion() == null) {
				throw new RuntimeException("Debe escribir un comentario");
			}else {
				comentario.setId(comentarioDao.nextId());
				return comentarioDao.save(comentario);
			}
		}
		
	}


	

}
