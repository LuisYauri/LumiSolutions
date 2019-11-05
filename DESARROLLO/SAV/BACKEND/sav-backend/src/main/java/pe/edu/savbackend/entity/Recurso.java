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
@Table(name = "recursos")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Recurso {
    @Id
    @Column(name="id")
    private Integer idRecurso;
    @Column(name="cod_tipo_recurso")
    private String codigoTipoRecurso;
    @Column(name="id_subcontenido")
    private Integer idSubcontenido;
    @Column(name="url_recurso")
    private String urlRecurso;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="promedio_calificacion")
    private Double promedioCalificacion;
}