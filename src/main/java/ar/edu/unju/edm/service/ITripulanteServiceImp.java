package ar.edu.unju.edm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Tripulante;
import ar.edu.unju.edm.repository.ITripulanteRepository;

@Service
public class ITripulanteServiceImp implements ITripulanteService{
	
	@Autowired
	ITripulanteRepository iTripulanteRepository;
	
	@Override
	public void guardarTripulante(Tripulante tripulante) {
		iTripulanteRepository.save(tripulante);
	}
}
