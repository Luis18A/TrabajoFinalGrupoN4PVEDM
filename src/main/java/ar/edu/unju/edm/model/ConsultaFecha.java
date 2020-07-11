package ar.edu.unju.edm.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class ConsultaFecha {

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaHora1;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaHora2;
	
	
	public ConsultaFecha() {
		// TODO Auto-generated constructor stub
	}


	public LocalDate getFechaHora1() {
		return fechaHora1;
	}


	public void setFechaHora1(LocalDate fechaHora1) {
		this.fechaHora1 = fechaHora1;
	}


	public LocalDate getFechaHora2() {
		return fechaHora2;
	}


	public void setFechaHora2(LocalDate fechaHora2) {
		this.fechaHora2 = fechaHora2;
	}
	
	
	
}
