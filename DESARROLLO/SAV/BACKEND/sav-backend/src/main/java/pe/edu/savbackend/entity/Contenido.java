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
@Table(name = "contenidos")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Contenido {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="tema")
    private String tema;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="cod_grado")
    private String cod_grado;
    @Column(name="id_criterio")
    private Integer id_criterio;
    @Column(name="url_imagen")
    private String url_imagen;
}