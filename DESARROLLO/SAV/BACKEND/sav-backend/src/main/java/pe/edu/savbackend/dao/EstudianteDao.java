package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.EstudianteDto;
import pe.edu.savbackend.domain.PROFESOR.ProEstudianteDto;
import pe.edu.savbackend.domain.PROFESOR.ProEstudiantePorMatricularDto;
import pe.edu.savbackend.entity.Estudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Integer> {

    @Query(value = "select new pe.edu.savbackend.domain.EstudianteDto(e.idEstudiante, p.nombre, p.apellidoPaterno, "
                 + "p.apellidoMaterno, u.username, u.password) from Estudiante e "
                 + "inner join Persona p on e.idPersona = p.idPersona "
                 + "inner join Usuario u on u.id = p.idUsuario"
          )
    List<EstudianteDto> obtenerListaAlumnos();

    @Query(value = "select max(e.idEstudiante) + 1 from Estudiante e")
    Integer nextId();
    
    @Query(value = "select new pe.edu.savbackend.domain.PROFESOR.ProEstudianteDto(e.idEstudiante, p.nombre, p.apellidoPaterno, p.apellidoMaterno, "
    		+ "u.username, function('date_format', ma.fechaMatricula,'%d/%m/%Y'))"
    		+ " from Estudiante e "
            + " join Persona p on e.idPersona = p.idPersona "
            + " join Usuario u on u.id = p.idUsuario "
            + " join Matricula ma on ma.idEstudiante = e.idEstudiante"
            + " where  ma.idGrupo = ?1"
     )
    List<ProEstudianteDto> filtrar(Integer idAula);
    
    @Query(value = "select new pe.edu.savbackend.domain.PROFESOR.ProEstudiantePorMatricularDto(e.idEstudiante, p.nombre, p.apellidoPaterno, "
            + "p.apellidoMaterno, u.username ) from Estudiante e "
            + "inner join Persona p on e.idPersona = p.idPersona "
            + "inner join Usuario u on u.id = p.idUsuario")
    List<ProEstudiantePorMatricularDto> listaAlumnosDisponibles();
    
    @Query(value = "select DISTINCT(m.idEstudiante) "
            + " from Matricula m "
            + " join Grupo g on m.idGrupo = g.id "
            + " where g.anio = ?1")
    List<Integer> estudiantesMatriculadosAnioActual(Integer anio);
}
