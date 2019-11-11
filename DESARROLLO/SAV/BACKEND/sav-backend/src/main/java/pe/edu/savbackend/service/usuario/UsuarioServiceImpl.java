package pe.edu.savbackend.service.usuario;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.UsuarioDao;
import pe.edu.savbackend.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public Usuario get(String idUsuario) {
		// TODO Auto-generated method stub
		return usuarioDao.getOne(idUsuario);
	}

	@Override
	public Usuario register(Usuario test) {
		// TODO Auto-generated method stub
//		test.setIdUsuario(testDao.nextId());
		return usuarioDao.save(test);
	}

	@Override
	public Usuario update(Usuario test) {
		// TODO Auto-generated method stub
//		if (!testDao.existsById(test.getIdUsuario())) {
//			throw new RuntimeException("No existe registro con id " + test.getIdUsuario());
//		}
		return usuarioDao.save(test);
	}

	@Override
	public void delete(String idUsuario) {
		usuarioDao.deleteById(idUsuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioDao.getOne(username);
		return new User(user.getUsername(),user.getContrasenia(),user.getCodigoEstado().equals("1"),user.getCodigoEstado().equals("1"),user.getCodigoEstado().equals("1"),user.getCodigoEstado().equals("1"),getGrante(user.getCodigoRoles()));
	}

	public List<GrantedAuthority> getGrante(String idRol){
		if(idRol.equals("1")) { // profesor
			return Arrays.asList(new SimpleGrantedAuthority("PROFESOR"),new SimpleGrantedAuthority("ALUMNO"));
		} else if (idRol.equals("2")){ // alumno
			return Arrays.asList(new SimpleGrantedAuthority("ALUMNO"));
		}
		return null;
		
	}
	
}
