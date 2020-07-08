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
	//private Localidad localidadAuxiliar = new Localidad();
	
	@Override
	public List<Localidad> obtenerLocalidades() {
		return iLocalidadRepository.obtenerLocalidades();
	}

	@Override
	public void guardarLocalidad(Localidad localidad) {
		iLocalidadRepository.save(localidad);
	}

//	@Override
//	public Localidad obtenerLocalidad(List<Localidad> localidad) {
//		
//		return localidadAuxiliar;
//	}

	@Override
	public Localidad modificar(Localidad unaLocalidad) throws Exception {
		// TODO Auto-generated method stub
		Localidad localidadGuardar = encontrarLocalidad(unaLocalidad.idLocalidad);
		mapearLocalidad(unaLocalidad, localidadGuardar);
		return iLocalidadRepository.save(localidadGuardar);
	}
	public void mapearLocalidad(Localidad desde, Localidad hacia) {
		hacia.setNombre(desde.getNombre());
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		iLocalidadRepository.deleteById(id);
	}

	@Override
	public Localidad encontrarLocalidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		return iLocalidadRepository.findById(id).orElseThrow(()-> new Exception("La localidad no existe"));
	}

}
