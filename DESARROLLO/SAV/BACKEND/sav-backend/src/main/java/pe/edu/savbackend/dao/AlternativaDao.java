package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.Alternativa;
/**
 * AlternativaDao
 */
public interface AlternativaDao extends JpaRepository<Alternativa, Integer>{

	@Query(value = "select a from Alternativa a where a.idPregunta = ?1")
	List<Alternativa> obtenerAlternativasPorIdPregunta(Integer idPregunta);
}