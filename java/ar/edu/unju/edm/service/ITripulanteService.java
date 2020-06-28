package ar.edu.unju.edm.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Tripulante;

@Service
public interface ITripulanteService {
	
	public void guardarTripulante(Tripulante tripulante);
}
