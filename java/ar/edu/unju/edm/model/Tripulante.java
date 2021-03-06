package ar.edu.unju.edm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tripulante")
public class Tripulante implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idTripulante;
	
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;
	
	
	public Tripulante(Long idTripulante, String documento, String apellido, String nombres, String nacionalidad) {
		super();
		this.idTripulante = idTripulante;
		this.documento = documento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.nacionalidad = nacionalidad;
	}
	public Tripulante() {
		// TODO Auto-generated constructor stub
	}
	public Long getIdTripulante() {
		return idTripulante;
	}
	public void setIdTripulante(Long idTripulante) {
		this.idTripulante = idTripulante;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((idTripulante == null) ? 0 : idTripulante.hashCode());
		result = prime * result + ((nacionalidad == null) ? 0 : nacionalidad.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
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
		Tripulante other = (Tripulante) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (idTripulante == null) {
			if (other.idTripulante != null)
				return false;
		} else if (!idTripulante.equals(other.idTripulante))
			return false;
		if (nacionalidad == null) {
			if (other.nacionalidad != null)
				return false;
		} else if (!nacionalidad.equals(other.nacionalidad))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tripulante [idTripulante=" + idTripulante + ", documento=" + documento + ", apellido=" + apellido
				+ ", nombres=" + nombres + ", nacionalidad=" + nacionalidad + "]";
	}
}
