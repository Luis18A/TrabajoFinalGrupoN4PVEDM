package ar.edu.unju.edm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import ar.edu.unju.edm.model.Vehiculo;
import ar.edu.unju.edm.repository.IVehiculoRepository;

@Service
public class IVehiculoServiceImp implements IVehiculoService{
	@Autowired
	IVehiculoRepository iVehiculoRepository;
	
	@Override
	public void guardarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		iVehiculoRepository.save(vehiculo);
	}


	@Override
	public Vehiculo modificar(Vehiculo vehiculo) throws Exception{
		Vehiculo guardarVehiculo= encontrarVehiculo(vehiculo.getId());
		mapearVehiculo(vehiculo, guardarVehiculo);
		return iVehiculoRepository.save(guardarVehiculo);
		
	}
	public void mapearVehiculo(Vehiculo desde, Vehiculo hacia) {
		hacia.setColor(desde.getColor());
		hacia.setId(desde.getId());
		hacia.setMarca(desde.getMarca());
		hacia.setModelo(desde.getModelo());
		hacia.setNumeroChasis(desde.getNumeroChasis());
		hacia.setNumeroMotor(desde.getNumeroMotor());
		hacia.setPatente(desde.getPatente());
		hacia.setTipo(desde.getTipo());
		hacia.setTitular(desde.getTitular());
	}


	@Override
	public Vehiculo encontrarVehiculo(Long idVehiculo) throws Exception{
		return iVehiculoRepository.findById(idVehiculo).orElseThrow(()-> new Exception("El vehiculo no existe"));
	}
	@Override
	public void eliminar(Long idVehiculo) {
		// TODO Auto-generated method stub
		iVehiculoRepository.deleteById(idVehiculo);
	}
	
	@Override
	public Iterable<Vehiculo> listarTodos() {
		// TODO Auto-generated method stub
		return iVehiculoRepository.findAll();
	}


	@Override
	public List<Vehiculo> obtenerVehiculo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Vehiculo> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
}