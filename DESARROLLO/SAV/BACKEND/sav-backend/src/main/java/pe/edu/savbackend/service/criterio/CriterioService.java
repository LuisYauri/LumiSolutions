package pe.edu.savbackend.service.criterio;

import java.util.List;

import pe.edu.savbackend.domain.CriterioDto;

public interface CriterioService {
 
	List<CriterioDto> getLsTareas(Integer idArea);
}
