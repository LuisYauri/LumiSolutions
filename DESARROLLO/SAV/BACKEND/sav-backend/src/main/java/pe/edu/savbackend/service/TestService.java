package pe.edu.savbackend.service;

import java.util.List;

import pe.edu.savbackend.domain.Test;

public interface TestService{
	
	public List<Test> getAll();
	
	public Test get(Integer idTest);
	
	public Test register(Test test);
	
	public Test update (Test test);
	
	public void delete (Integer idTest);
}
