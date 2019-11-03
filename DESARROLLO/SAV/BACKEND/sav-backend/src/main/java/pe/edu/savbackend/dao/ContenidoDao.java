package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.ContenidoDto;
import pe.edu.savbackend.entity.Contenido;


public interface ContenidoDao extends JpaRepository<Contenido, Integer> {
	
	@Query(value = "select new pe.edu.savbackend.domain.ContenidoDto(c.idCriterio, c.idContenido, c.nombre, c.urlImagen) from Contenido c where c.idCriterio = ?1 and c.codigoGrado = ?2")
	List<ContenidoDto> getLsContenidos(Integer idCriterio, String codigoGrado);
	
}
