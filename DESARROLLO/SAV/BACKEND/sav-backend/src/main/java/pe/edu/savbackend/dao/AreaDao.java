package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Area;


public interface AreaDao extends JpaRepository<Area, Integer> {
}
