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
@Table(name = "criterios")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Criterio {
    @Id
    @Column(name="id")
    private Integer idCriterio;
    @Column(name="nombre")
    private String nombre;
    @Column(name="id_area")
    private Integer idArea;
    @Column(name="url_imagen")
    private String urlImagen;
}