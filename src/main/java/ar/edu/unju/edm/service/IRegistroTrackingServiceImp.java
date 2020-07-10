package ar.edu.unju.edm.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.RegistroTracking;
import ar.edu.unju.edm.repository.IRegistroTrackingRepository;

@Service
public class IRegistroTrackingServiceImp implements IRegistroTrackingService{

	@Autowired
	IRegistroTrackingRepository iRegistroTrackingRepository;
	
	@Override
	public void guardarRegistroTracking(RegistroTracking registroTracking) {
		registroTracking.setFechaHora(LocalDateTime.now());
		iRegistroTrackingRepository.save(registroTracking);
	}
//agregado
	@Override
	public List<RegistroTracking> obtenerRegistros(Long id) {
		List<RegistroTracking> registros = iRegistroTrackingRepository.findByIdVehiculoOrderByFechaHoraAsc(id);
		return registros;
	}
	//agrego
	@Override
	public List<RegistroTracking> obtenerRegistrosT(Long id) {
		// TODO Auto-generated method stub
		List<RegistroTracking> registros = iRegistroTrackingRepository.findByIdTripulanteOrderByFechaHoraAsc(id);
		return registros;
	}
}
