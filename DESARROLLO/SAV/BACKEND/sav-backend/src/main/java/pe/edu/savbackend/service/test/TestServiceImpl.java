package pe.edu.savbackend.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.TestDao;
import pe.edu.savbackend.domain.Test;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao testDao;

	@Override
	public List<Test> getAll() {
		// TODO Auto-generated method stub
		return testDao.findAll();
	}

	@Override
	public Test get(Integer idTest) {
		// TODO Auto-generated method stub
		return testDao.getOne(idTest);
	}

	@Override
	public Test register(Test test) {
		// TODO Auto-generated method stub
		test.setIdTest(testDao.nextId());
		return testDao.save(test);
	}

	@Override
	public Test update(Test test) {
		// TODO Auto-generated method stub
		if (!testDao.existsById(test.getIdTest())) {
			throw new RuntimeException("No existe registro con id " + test.getIdTest());
		}
		return testDao.save(test);
	}

	@Override
	public void delete(Integer idTest) {
		testDao.deleteById(idTest);
	}

}
