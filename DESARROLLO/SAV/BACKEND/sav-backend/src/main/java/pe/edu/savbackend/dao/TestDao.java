package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.domain.Test;

public interface TestDao extends JpaRepository<Test,Integer>{

}
