package ar.unju.edu.edm.service;


import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Vehiculo;

@Service
public interface IVehiculoService {
	
	public void guardarVehiculo(Vehiculo vehiculo);
	public Vehiculo buscarVehiculo(Integer  idVehiculo);
	public Iterable<Vehiculo> buscarTodosVehiculo();
}
