package pe.edu.savbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Plantilla
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "plantillas")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Plantilla {

    //Llave primaria
    @Id
	@Column(name="id")
    private Integer id;
    
    //Llave foránea
    @Column(name="id_recurso")
    private Integer idRecurso;
    
    //Atributos
	@Column(name="descripcion")
	private String descripcion;
    
}