package ar.edu.unju.edm.service;


import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Vehiculo;

@Service
public interface IVehiculoService {
	
	public void guardarVehiculo(Vehiculo vehiculo);
	public List<Vehiculo> obtenerVehiculos();
	public Vehiculo obtenerVehiculo(Vehiculo vehiculo);
	public void guardarVehiculoEncontrado(Vehiculo vehiculo);
	public Vehiculo buscarVehiculo(String patente)  throws Exception;
	public void borrarVehiculoA();
/**	public Vehiculo buscarVehiculo(Integer  idVehiculo);
	public Iterable<Vehiculo> buscarTodosVehiculo();
	**/
	
}
