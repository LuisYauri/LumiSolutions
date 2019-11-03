package pe.edu.savbackend.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.comentario.RecursoDto;
import pe.edu.savbackend.entity.Contenido;
import pe.edu.savbackend.entity.Recurso;


public interface RecursoDao extends JpaRepository<Recurso, Integer> {


    //Integer alumnoCalificacion, 
    @Query
    (value = "select new pe.edu.savbackend.domain.comentario.RecursoDto( " 
           + "r.id, r.nombre, r.descripcion, r.codigoTipoRecurso, "
           + "r.urlRecurso, c.calificacion, r.promedioCalificacion) "
           + "from Recurso r join Calificacion c on r.id = c.idRecurso where r.id = ?1 and c.idEstudiante = ?2"
    ) 
    RecursoDto obtenerPorId(Integer idRecurso,Integer idEstudiante);


    @Query
    (value = "select new pe.edu.savbackend.domain.comentario.RecursoDto( " 
           + "r.id, r.nombre, r.descripcion, r.codigoTipoRecurso, "
           + "r.urlRecurso, c.calificacion, r.promedioCalificacion) "
           + "from Recurso r join Calificacion c on r.id = c.idRecurso where r.idDetalleContenido = ?1"
    ) 
    List<RecursoDto> filtrarPorIdSubcontenido(Integer idSubContenido);


}
