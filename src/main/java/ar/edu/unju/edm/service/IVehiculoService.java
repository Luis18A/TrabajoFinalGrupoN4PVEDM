package ar.edu.unju.edm.service;

//Resubido
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Vehiculo;

@Service
public interface IVehiculoService {
	
	public void guardarVehiculo(Vehiculo vehiculo);
	public List<Vehiculo> obtenerUsuarios();	
	public Vehiculo modificar(Vehiculo vehiculo) throws Exception;
	public void eliminar(Long id);
	public Vehiculo encontrarVehiculo(Long id) throws Exception;

	public Iterable<Vehiculo> listarTodos();
	List<Vehiculo> obtenerVehiculo();
	

}