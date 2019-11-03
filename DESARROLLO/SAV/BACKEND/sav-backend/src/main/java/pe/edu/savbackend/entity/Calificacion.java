package pe.edu.savbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "calificaciones")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Calificacion {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="calificacion")
    private Integer calificacion;
    @Column(name="id_estudiante")
    private Integer idEstudiante;
    @Column(name="id_recurso")
    private Integer idRecurso;
}