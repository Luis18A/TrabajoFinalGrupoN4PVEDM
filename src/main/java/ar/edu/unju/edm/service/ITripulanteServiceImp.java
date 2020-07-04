package ar.edu.unju.edm.service;

import java.util.List;

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

	@Override
	public List<Tripulante> obtenerTripulantes() {
		return iTripulanteRepository.obtenerTripulantes();
	}
   
	
	@Override
	public Tripulante modificar(Tripulante unTripulante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tripulante encontrarTripulante(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tripulante> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
