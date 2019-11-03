package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.Test;

public interface TestDao extends JpaRepository<Test, Integer> {
	@Query(value = "select max(t.idTest)+ 1 from Test t")
	Integer nextId();
	
//	@Query(value = "select new pe.edu.savbackend.domain.Tarea(u.username, p.nombre) from Usuario u JOIN Persona p")
//	List<Tarea> ejemplo();
}
