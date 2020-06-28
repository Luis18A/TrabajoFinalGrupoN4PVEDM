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
	public List<Vehiculo> obtenerVehiculos() {
		return iVehiculoRepository.obtenerVehiculos();
	}

	/**@Override
	public Vehiculo buscarVehiculo(Integer idVehiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Vehiculo> buscarTodosVehiculo() {
		// TODO Auto-generated method stub
		return iVehiculoRepository.findAll();
	}
	**/
}
