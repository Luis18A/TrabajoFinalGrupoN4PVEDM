package ar.edu.unju.edm.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="registroTracking")
public class RegistroTracking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idRegistro;
	
	@Column(name = "FECHAHORA")
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private LocalDateTime fechaHora;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IDVEHICULO")
	private Vehiculo vehiculo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (name = "REGISTROTRACKING_TRIPULANTE", 
	joinColumns = @JoinColumn(name = "IDREGISTROTRACKING"), 
	inverseJoinColumns = @JoinColumn(name = "IDTRIPULANTE"))
	@Column(name = "TRIPULANTES")
	private List<Tripulante> tripulantes;
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IDLOCALIDAD")
	private Localidad localidad;
	
	@Column(name = "DETALLELUGARREGISTRO")
	private String detalleLugarRegistro;

	public RegistroTracking(Long idRegistro, LocalDateTime fechaHora, Vehiculo vehiculo, List<Tripulante> tripulantes,
			Localidad localidad, String detalleLugarRegistro) {
		super();
		this.idRegistro = idRegistro;
		this.fechaHora = fechaHora;
		this.vehiculo = vehiculo;
		this.tripulantes = tripulantes;
		this.localidad = localidad;
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	public Long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}

	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalleLugarRegistro == null) ? 0 : detalleLugarRegistro.hashCode());
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
		result = prime * result + ((idRegistro == null) ? 0 : idRegistro.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((tripulantes == null) ? 0 : tripulantes.hashCode());
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		RegistroTracking other = (RegistroTracking) obj;
		if (detalleLugarRegistro == null) {
			if (other.detalleLugarRegistro != null)
				return false;
		} else if (!detalleLugarRegistro.equals(other.detalleLugarRegistro))
			return false;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		if (idRegistro == null) {
			if (other.idRegistro != null)
				return false;
		} else if (!idRegistro.equals(other.idRegistro))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (tripulantes == null) {
			if (other.tripulantes != null)
				return false;
		} else if (!tripulantes.equals(other.tripulantes))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegistroTracking [idRegistro=" + idRegistro + ", fechaHora=" + fechaHora + ", vehiculo=" + vehiculo
				+ ", tripulantes=" + tripulantes + ", localidad=" + localidad + ", detalleLugarRegistro="
				+ detalleLugarRegistro + "]";
	}
	
	
}
