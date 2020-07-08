package ar.edu.unju.edm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="localidad")
public class Localidad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long idLocalidad;
	
	@Column(name = "NOMBRE", nullable = true)
	private String nombre;
	
	@OneToMany(mappedBy = "localidad")
	private List<RegistroTracking> registrostracking = new ArrayList<RegistroTracking>();
	
	public Localidad() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RegistroTracking> getRegistrostracking() {
		return registrostracking;
	}

	public void setRegistrostracking(List<RegistroTracking> registrostracking) {
		this.registrostracking = registrostracking;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idLocalidad == null) ? 0 : idLocalidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime
				* result
				+ ((registrostracking == null) ? 0 : registrostracking
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidad other = (Localidad) obj;
		if (idLocalidad == null) {
			if (other.idLocalidad != null)
				return false;
		} else if (!idLocalidad.equals(other.idLocalidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (registrostracking == null) {
			if (other.registrostracking != null)
				return false;
		} else if (!registrostracking.equals(other.registrostracking))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", nombre=" + nombre
				+ ", registrostracking=" + registrostracking + "]";
	}

	public Localidad(Long idLocalidad, String nombre,
			List<RegistroTracking> registrostracking) {
		super();
		this.idLocalidad = idLocalidad;
		this.nombre = nombre;
		this.registrostracking = registrostracking;
	}
	
	
	
	
}
