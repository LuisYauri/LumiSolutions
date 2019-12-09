package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.edu.savbackend.domain.usuario.UsuarioDto;
import pe.edu.savbackend.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByUsername(String username);
	
	
	@Query(value = "select new pe.edu.savbackend.domain.usuario.UsuarioDto(u.id, u.username, p.apellidoPaterno, p.nombre, p.codigoTipoPersona) "
			+ " from Usuario u "
			+ " join Persona p on p.idUsuario = u.id "
			+ " where u.username = ?1")
	UsuarioDto buscarPorUsername(String username);
	
//	@Query(value = "select max(u.id) + 1 from Usuario u")
//    Integer nextId();
}


