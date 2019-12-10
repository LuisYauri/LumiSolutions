package pe.edu.savbackend.service.usuario;

import java.util.List;

import pe.edu.savbackend.domain.usuario.UsuarioDto;
import pe.edu.savbackend.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> buscar();
	
	public void guardar(Usuario usuario);
		
	public void eliminar(Integer id);	
	
	public Usuario findByUsername(String username);
	
	public UsuarioDto buscarPorUsername(String username);
}
