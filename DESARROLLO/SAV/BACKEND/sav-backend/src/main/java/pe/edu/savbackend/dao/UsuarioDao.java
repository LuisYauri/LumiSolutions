package pe.edu.savbackend.dao;

import org.springframework.data.repository.CrudRepository;

import pe.edu.savbackend.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);

}


