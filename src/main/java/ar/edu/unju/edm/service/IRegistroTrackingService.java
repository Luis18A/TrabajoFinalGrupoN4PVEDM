package ar.edu.unju.edm.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.RegistroTracking;

@Service
public interface IRegistroTrackingService {

	public void guardarRegistroTracking(RegistroTracking registroTracking);

}
