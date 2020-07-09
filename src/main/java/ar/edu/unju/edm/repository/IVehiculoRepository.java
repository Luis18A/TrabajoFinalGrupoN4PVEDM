package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Vehiculo;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long>{

//	public Optional<RegistroTracking> findByPatenteRegistro(String patente);

	@Query("from Vehiculo e order by e.id")
	public List<Vehiculo> obtenerVehiculos();
	public Optional<Vehiculo> findByPatente(String patente);
	
	
	
//	public List<RegistroTracking> findByIdVehiculo(Long id);
//	@Query("from RegistroTracking e order by e.fechaHora")
//	public List<RegistroTracking> obtenerVehiculosO(List<RegistroTracking> listaO);

}
