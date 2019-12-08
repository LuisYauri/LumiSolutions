package pe.edu.savbackend.service.aula;

import java.util.List;

import pe.edu.savbackend.domain.AulaDto;
import pe.edu.savbackend.entity.Grupo;

public interface AulaService {

	List<AulaDto> getLsAulas();

	Grupo registrarAula(AulaDto aula);
	
	Boolean actualizarAula(AulaDto aula);
	
	Boolean eliminarAula(Integer idArea);
}
