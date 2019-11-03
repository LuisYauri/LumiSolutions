package pe.edu.savbackend.service.subcontenidos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.ContenidoDao;
import pe.edu.savbackend.dao.SubcontenidoDao;
import pe.edu.savbackend.domain.ContenidoDto;

@Service
public class SubcontenidosServiceImpl implements SubcontenidosService {

	@Autowired
	private SubcontenidoDao subcontenidoDao;
	
	@Autowired
	private ContenidoDao contenidoDao;

	@Override
	public ContenidoDto getLsubContenido(Integer idContenido) {
		//contar las tareas formatear la fecha 
		ContenidoDto contenidodto = new ContenidoDto();
		//if (contenidoDao.findById(idContenido) != null) {
			contenidodto.setNombre(contenidoDao.findById(idContenido).get().getNombre());
			contenidodto.setLsSubContenido(subcontenidoDao.getLsubContenido(idContenido));
			return contenidodto;
		//}
		//return null;
	}

	

}
