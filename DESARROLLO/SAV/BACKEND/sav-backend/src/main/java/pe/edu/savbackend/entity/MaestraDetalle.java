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
@Table(name = "maestra_detalles")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class MaestraDetalle {
    @Id
    @Column(name="codigo")
    private Integer id;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="id_tabla")
    private Integer id_tabla;
}