package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.edu.savbackend.domain.usuario.UsuarioDto;
import pe.edu.savbackend.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	
	
	@Query(value = "select new pe.edu.savbackend.domain.UsuarioDto(u.id, u.username, p.apellidoPaterno, p.nombre) "
			+ " from Usuario u "
			+ " join Persona p on p.id_usuario = u.id "
			+ " where u.id = ?1")
	UsuarioDto buscarPorUsername(String username);
}


