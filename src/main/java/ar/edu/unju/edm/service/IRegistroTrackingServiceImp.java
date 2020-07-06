package ar.edu.unju.edm.service;

import java.time.LocalDateTime;

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

}
