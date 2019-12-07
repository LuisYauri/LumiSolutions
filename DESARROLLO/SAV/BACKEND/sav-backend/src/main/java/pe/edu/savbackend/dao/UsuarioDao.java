package pe.edu.savbackend.dao;

import org.springframework.data.repository.CrudRepository;

import pe.edu.savbackend.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	
	
//	@Query(value = "select new pe.edu.savbackend.domain.SubContenidoDto(e.idSubcontenido, e.nombre, e.descripcion, e.urlImagen) from Subcontenido e join Contenido ee on e.idContenido = ee.idContenido where ee.idContenido >= ?1 AND ee.idContenido <= (?1 +2)")
//	UsuarioDto buscarPorUsername(String username);
}


