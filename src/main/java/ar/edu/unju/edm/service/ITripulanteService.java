package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Tripulante;


@Service
public interface ITripulanteService {
	
	public void guardarTripulante(Tripulante tripulante);
	public List<Tripulante> obtenerTripulantes();	
	public Tripulante modificar(Tripulante unTripulante) throws Exception;
	public void eliminar(Long id);
	public Tripulante encontrarTripulante(Long id) throws Exception;
	public Iterable<Tripulante> listarTodos();

}
