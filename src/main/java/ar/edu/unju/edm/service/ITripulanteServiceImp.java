package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Tripulante;
import ar.edu.unju.edm.repository.ITripulanteRepository;

@Service
public class ITripulanteServiceImp implements ITripulanteService{
	
	@Autowired
	ITripulanteRepository iTripulanteRepository;
	//agregado
	private List<Tripulante> listadoAuxiliar = new ArrayList<>();
	
	
	@Override
	public void guardarTripulante(Tripulante tripulante) {
		iTripulanteRepository.save(tripulante);
		//agregado
		listadoAuxiliar.add(tripulante);
	}

	@Override
	public List<Tripulante> obtenerTripulantes() {
		//cambiado
		return listadoAuxiliar;
	}
	//son los tripulantes del registro, no todos los de la bd

	
	//agregado
	@Override
	public void guardarTripulanteEncontrado(Tripulante tripulante) {
		listadoAuxiliar.add(tripulante);
	}

	@Override
	public Tripulante buscarTripulante(String documento) throws Exception {
		return iTripulanteRepository.findByDocumento(documento).orElseThrow(()-> new Exception("El tripulante no existe")) ;
	}

	@Override
	public void borrarTripulantes() {
		listadoAuxiliar = new ArrayList<>();
	}
}
