package pe.edu.savbackend.service.usuario;

import java.util.List;

import pe.edu.savbackend.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> getAll();

	public Usuario get(String idUsuario);

	public Usuario register(Usuario usuario);

	public Usuario update(Usuario usuario);

	public void delete(String idUsuario);
}
