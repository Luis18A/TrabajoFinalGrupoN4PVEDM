package ar.edu.unju.edm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.ConsultaFecha;
import ar.edu.unju.edm.model.RegistroTracking;
import ar.edu.unju.edm.model.Tripulante;
import ar.edu.unju.edm.repository.IRegistroTrackingRepository;
	
@Service
public class IRegistroTrackingServiceImp implements IRegistroTrackingService{

	@Autowired
	IRegistroTrackingRepository iRegistroTrackingRepository;
	private ConsultaFecha consultaAuxiliar = new ConsultaFecha();
	private List<RegistroTracking> registros = new ArrayList<>();
	private List<Tripulante> tripulantes = new ArrayList<>();

	
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
//	@Override
//	public List<RegistroTracking> obtenerRegistrosT(Long id) {
//		// TODO Auto-generated method stub
//		List<RegistroTracking> registros = iRegistroTrackingRepository.findByIdTripulanteOrderByFechaHoraAsc(id);
//		return registros;
//	}
	
	
	//agregado2
	@Override
	public List<RegistroTracking> obtenerRegistrosOL(LocalDateTime date1, LocalDateTime date2, Long id){
		List<RegistroTracking> registros = iRegistroTrackingRepository.findByFechaHoraBetween(date1, date2, id);
		return registros;
	}
	@Override
	public void guardarFechas(ConsultaFecha consulta) {
		consultaAuxiliar = consulta;
	}
	@Override
	public ConsultaFecha obtenerFechas() {
		return consultaAuxiliar;
	}
	
	
	//consulta2nuevo
	@Override
	public List<RegistroTracking> obtenerRegistrosCD(Tripulante tripulante) {
//		RegistroTracking registro;
//		for (int i=0;i<=tripulante.getRegistrosT().size();i++){
//			registro = tripulante.getRegistrosT().get(i);
//			System.out.println(registro.getIdRegistro());
//			registros.add(registro);
//		}		
		registros = tripulante.getRegistrosT();
		
		return registros;
	}
	
	
	//consulta1nuevo
	
	@Override
	public RegistroTracking buscarRegistro(Long id) {
		return iRegistroTrackingRepository.findByIdRegistro(id);
	}
	
	
	
	@Override
	public List<Tripulante> obtenerTripulantes(RegistroTracking registroTracking) {
		
		tripulantes = registroTracking.getTripulantes();
		//tripulantes = ;
		return tripulantes;
	}
	


	
//	consulta2
//	@Override
//	public List<RegistroTracking> obtenerRegistrosT(Long id) {
//		List<RegistroTracking> registros = iRegistroTrackingRepository.findByIdTripulanteOrderByFechaHoraAsc(id);
//		return registros;
//	}

	
}
