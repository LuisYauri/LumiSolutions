package pe.edu.savbackend.service.usuario;

import java.util.List;

import pe.edu.savbackend.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> buscar();
	
	public void guardar(Usuario usuario);
		
	public void eliminar(Long id);	
	
	public Usuario findByUsername(String username);
}
