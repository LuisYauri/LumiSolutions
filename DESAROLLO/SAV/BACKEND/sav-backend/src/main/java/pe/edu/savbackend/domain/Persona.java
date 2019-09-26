package pe.edu.savbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Departamento
 */
//@ApiModel(description = "Persona")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Persona {

	@Id
	@Column(name = "dni_persona")
	private String dni;
	@Column(name = "nombre")
	private String nombre;
//	public String getDni() {
//		return dni;
//	}
//	public void setDni(String dni) {
//		this.dni = dni;
//	}
//	public String getNombre() {
//		return nombre;
//	}
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//	@Override
//	public String toString() {
//		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
//	}
	
	
	
}