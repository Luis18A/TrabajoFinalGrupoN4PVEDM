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
	private Vehiculo vehiculoAuxiliar = new Vehiculo();
	
	@Override
	public void guardarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		iVehiculoRepository.save(vehiculo);
		vehiculoAuxiliar=vehiculo;
	}

	@Override
	public List<Vehiculo> obtenerVehiculos() {
		return iVehiculoRepository.obtenerVehiculos();
	}

	@Override
	public Vehiculo obtenerVehiculo(Vehiculo vehiculo) {
		return vehiculoAuxiliar;
	}

	@Override
	public void guardarVehiculoEncontrado(Vehiculo vehiculo) {
		vehiculoAuxiliar=vehiculo;
	}

	@Override
	public Vehiculo buscarVehiculo(String patente) throws Exception {
		return iVehiculoRepository.findByPatente(patente).orElseThrow(()-> new Exception("El vehiculo no existe")) ;		
	}

	@Override
	public void borrarVehiculoA() {
		vehiculoAuxiliar=new Vehiculo();		
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
