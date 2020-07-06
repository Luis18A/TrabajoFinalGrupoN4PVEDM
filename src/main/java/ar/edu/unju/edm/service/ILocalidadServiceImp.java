package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Localidad;
import ar.edu.unju.edm.repository.ILocalidadRepository;

@Service
public class ILocalidadServiceImp implements ILocalidadService{

	@Autowired
	ILocalidadRepository iLocalidadRepository;
	private Localidad localidadAuxiliar = new Localidad();
	
	@Override
	public List<Localidad> obtenerLocalidades() {
		return iLocalidadRepository.obtenerLocalidades();
	}

	@Override
	public void guardarLocalidad(Localidad localidad) {
		iLocalidadRepository.save(localidad);
	}

	@Override
	public Localidad obtenerLocalidad(List<Localidad> localidad) {
		
		return localidadAuxiliar;
	}

}
