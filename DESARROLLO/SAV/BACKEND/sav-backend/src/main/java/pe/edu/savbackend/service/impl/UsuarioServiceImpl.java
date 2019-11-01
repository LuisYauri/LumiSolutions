package pe.edu.savbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.UsuarioDao;
import pe.edu.savbackend.entity.Usuario;
import pe.edu.savbackend.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao testDao;

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return testDao.findAll();
	}

	@Override
	public Usuario get(String idUsuario) {
		// TODO Auto-generated method stub
		return testDao.getOne(idUsuario);
	}

	@Override
	public Usuario register(Usuario test) {
		// TODO Auto-generated method stub
//		test.setIdUsuario(testDao.nextId());
		return testDao.save(test);
	}

	@Override
	public Usuario update(Usuario test) {
		// TODO Auto-generated method stub
//		if (!testDao.existsById(test.getIdUsuario())) {
//			throw new RuntimeException("No existe registro con id " + test.getIdUsuario());
//		}
		return testDao.save(test);
	}

	@Override
	public void delete(String idUsuario) {
		testDao.deleteById(idUsuario);
	}

}
