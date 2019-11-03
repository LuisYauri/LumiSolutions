package pe.edu.savbackend.service.contenido;

import java.util.List;

import pe.edu.savbackend.domain.ContenidoDto;

public interface ContenidoService {

	List<ContenidoDto> getLsContenido(Integer idCriterio, String codigoGrado);
}
