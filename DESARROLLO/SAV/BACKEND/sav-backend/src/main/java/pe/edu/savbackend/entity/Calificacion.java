package pe.edu.savbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.entity.ids.CalificacionId;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "calificaciones")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@IdClass(CalificacionId.class)
public class Calificacion {
    @Id
    @Column(name="id_estudiante")
    private Integer idEstudiante;
    
    @Id
    @Column(name="id_recurso")
    private Integer idRecurso;
    
    @Column(name="calificacion")
    private Integer calificacion;
}