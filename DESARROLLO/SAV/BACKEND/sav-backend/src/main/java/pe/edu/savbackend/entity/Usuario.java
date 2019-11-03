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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuarios")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="contrasenia")
	private String contrasenia;
	@Column(name="cod_estado")
	private String codigoEstado;
	@Column(name="cod_rol")
	private String codigoRoles;
}
