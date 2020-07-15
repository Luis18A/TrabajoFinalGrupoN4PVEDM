package ar.edu.unju.edm.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.ConsultaFecha;
import ar.edu.unju.edm.model.RegistroTracking;
import ar.edu.unju.edm.model.Tripulante;

@Service
public interface IRegistroTrackingService {
	
	public void guardarRegistroTracking(RegistroTracking registroTracking);
	
	public List<RegistroTracking> obtenerRegistros(Long id);
//	consulta2
//	public List<RegistroTracking> obtenerRegistrosT(Long id);
	//agregado2
	public List<RegistroTracking> obtenerRegistrosOL(LocalDateTime date1, LocalDateTime date2, Long id);

	public void guardarFechas(ConsultaFecha consulta);
	public ConsultaFecha obtenerFechas();
	
	
	//consulta2nuevo
	public List<RegistroTracking> obtenerRegistrosCD(Tripulante tripulante);
	
}
