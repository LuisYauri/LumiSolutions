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
@Table(name = "personas")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Persona {
    @Id
    private Integer id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
    @Column(name="apellido_materno")
    private String apellidoMaterno;
    @Column(name="numero_celular")
    private Integer numeroCelular;
    @Column(name="correo")
	private String correo;
}