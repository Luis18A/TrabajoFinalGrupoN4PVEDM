package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Localidad;

@Service
public interface ILocalidadService {
	
	public void guardarLocalidad(Localidad localidad);
	public List<Localidad> obtenerLocalidades();
//	public Localidad obtenerLocalidad(List<Localidad> localidad);
	
	public Localidad modificar(Localidad unaLocalidad) throws Exception;
	public void eliminar(Long id);
	public Localidad encontrarLocalidad(Long id) throws Exception;

	public Localidad buscarLocalidad(String nombre)  throws Exception;
	public Long devolverIdLocalidad(Localidad localidad);

}
