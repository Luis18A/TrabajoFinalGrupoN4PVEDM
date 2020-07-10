package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.RegistroTracking;

@Service
public interface IRegistroTrackingService {

	public void guardarRegistroTracking(RegistroTracking registroTracking);
	
	public List<RegistroTracking> obtenerRegistros(Long id);
	//agregado T
	public List<RegistroTracking> obtenerRegistrosT(Long id);

}
