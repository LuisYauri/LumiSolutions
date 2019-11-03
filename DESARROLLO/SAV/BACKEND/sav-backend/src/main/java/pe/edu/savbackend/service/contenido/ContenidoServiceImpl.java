package pe.edu.savbackend.service.contenido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.ContenidoDao;
import pe.edu.savbackend.domain.ContenidoDto;

@Service
public class ContenidoServiceImpl implements ContenidoService {

	@Autowired
	private ContenidoDao contenidoDao;
	
	@Override
	public List<ContenidoDto> getLsContenido(Integer idCriterio, String codigoGrado) {
		// TODO Auto-generated method stub
		return contenidoDao.getLsContenidos(idCriterio, codigoGrado);
		
	}


	

}
