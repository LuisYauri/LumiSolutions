package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.SubContenidoDto;
import pe.edu.savbackend.entity.Subcontenido;

/**
 SubcontenidoDao
 */
public interface SubcontenidoDao extends JpaRepository<Subcontenido, Integer> {
 
	@Query(value = "select new pe.edu.savbackend.domain.SubContenidoDto(e.id, e.nombre, e.descripcion, e.urlImagen) from Subcontenido e join Contenido ee on e.idContenido = ee.id where ee.id >= ?1 AND ee.id <= (?1 +2)")
	List<SubContenidoDto> getLsubContenido(Integer idContenido);
}
