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
@Table(name = "subcontenidos")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Subcontenido {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="id_contenido")
    private Integer idContenido;
    @Column(name="nombre")
    private String nombre;
    @Column(name="url_imagen")
    private String urlImagen;
}