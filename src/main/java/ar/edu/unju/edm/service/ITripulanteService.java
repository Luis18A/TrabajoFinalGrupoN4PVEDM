package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Tripulante;

@Service
public interface ITripulanteService {
	
	public void guardarTripulante(Tripulante tripulante);
	public List<Tripulante> obtenerTripulantes();
	
	//agregado
	public void guardarTripulanteEncontrado(Tripulante tripulante);
	public Tripulante buscarTripulante(String documento)  throws Exception;
	public void borrarTripulantes();

	//ultimo agregado
	public Long devolverIdTripulante(Tripulante tripulante);
}
