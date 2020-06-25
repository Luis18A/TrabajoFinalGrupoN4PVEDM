package ar.edu.unju.edm.model;

import java.io.Serializable;

public class Vehiculo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer IdVehiculo;
	private String patente;
	private String color;
	private String titular;
	private String marca;
	private String modelo;
	private String tipo;
	private String numeroChasis;
	private String numeroMotor;
	
public Vehiculo() {
	
}
public Vehiculo(String patente, String color, String titular, String marca, String modelo, String tipo,
		String numeroChasis, String numeroMotor, Integer idVehiculo) {
	super();
	this.patente = patente;
	this.color = color;
	this.titular = titular;
	this.marca = marca;
	this.modelo = modelo;
	this.tipo = tipo;
	this.numeroChasis = numeroChasis;
	this.numeroMotor = numeroMotor;
	IdVehiculo = idVehiculo;
}
public String getPatente() {
	return patente;
}
public void setPatente(String patente) {
	this.patente = patente;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getTitular() {
	return titular;
}
public void setTitular(String titular) {
	this.titular = titular;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getNumeroChasis() {
	return numeroChasis;
}
public void setNumeroChasis(String numeroChasis) {
	this.numeroChasis = numeroChasis;
}
public String getNumeroMotor() {
	return numeroMotor;
}
public void setNumeroMotor(String numeroMotor) {
	this.numeroMotor = numeroMotor;
}
public Integer getIdVehiculo() {
	return IdVehiculo;
}
public void setIdVehiculo(Integer idVehiculo) {
	IdVehiculo = idVehiculo;
}
@Override
public String toString() {
	return "Vehiculo [patente=" + patente + ", color=" + color + ", titular=" + titular + ", marca=" + marca
			+ ", modelo=" + modelo + ", tipo=" + tipo + ", numeroChasis=" + numeroChasis + ", numeroMotor="
			+ numeroMotor + ", IdVehiculo=" + IdVehiculo + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((IdVehiculo == null) ? 0 : IdVehiculo.hashCode());
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	result = prime * result + ((marca == null) ? 0 : marca.hashCode());
	result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
	result = prime * result + ((numeroChasis == null) ? 0 : numeroChasis.hashCode());
	result = prime * result + ((numeroMotor == null) ? 0 : numeroMotor.hashCode());
	result = prime * result + ((patente == null) ? 0 : patente.hashCode());
	result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
	result = prime * result + ((titular == null) ? 0 : titular.hashCode());
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
	Vehiculo other = (Vehiculo) obj;
	if (IdVehiculo == null) {
		if (other.IdVehiculo != null)
			return false;
	} else if (!IdVehiculo.equals(other.IdVehiculo))
		return false;
	if (color == null) {
		if (other.color != null)
			return false;
	} else if (!color.equals(other.color))
		return false;
	if (marca == null) {
		if (other.marca != null)
			return false;
	} else if (!marca.equals(other.marca))
		return false;
	if (modelo == null) {
		if (other.modelo != null)
			return false;
	} else if (!modelo.equals(other.modelo))
		return false;
	if (numeroChasis == null) {
		if (other.numeroChasis != null)
			return false;
	} else if (!numeroChasis.equals(other.numeroChasis))
		return false;
	if (numeroMotor == null) {
		if (other.numeroMotor != null)
			return false;
	} else if (!numeroMotor.equals(other.numeroMotor))
		return false;
	if (patente == null) {
		if (other.patente != null)
			return false;
	} else if (!patente.equals(other.patente))
		return false;
	if (tipo == null) {
		if (other.tipo != null)
			return false;
	} else if (!tipo.equals(other.tipo))
		return false;
	if (titular == null) {
		if (other.titular != null)
			return false;
	} else if (!titular.equals(other.titular))
		return false;
	return true;
}






}
