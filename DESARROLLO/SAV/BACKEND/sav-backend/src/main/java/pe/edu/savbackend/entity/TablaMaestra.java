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

/**
 * TablaMaestra
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tabla_maestra")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class TablaMaestra {
    @Id
    @Column(name="id_tabla_maestra")
    private Integer idTablaMaestra;
    
    @Column(name="descripcion")
    private String descripcion;
}