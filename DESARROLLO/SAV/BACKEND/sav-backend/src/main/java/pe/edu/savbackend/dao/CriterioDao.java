package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.CriterioDto;
import pe.edu.savbackend.entity.Criterio;


public interface CriterioDao extends JpaRepository<Criterio, Integer> {
  
	@Query(value = "select new pe.edu.savbackend.domain.CriterioDto(c.id, c.nombre, c.urlImagen) from Criterio c")
	List<CriterioDto> getLsCriterio(Integer idArea);
	
}
