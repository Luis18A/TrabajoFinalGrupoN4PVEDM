package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Localidad;

@Service
public interface ILocalidadService {
	
	public void guardarLocalidad(Localidad localidad);
	public List<Localidad> obtenerLocalidades();
	public Localidad obtenerLocalidad(List<Localidad> localidad);

}
