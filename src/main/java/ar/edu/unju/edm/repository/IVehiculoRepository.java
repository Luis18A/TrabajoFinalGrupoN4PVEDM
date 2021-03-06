package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Vehiculo;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long>{


	@Query("from Vehiculo e order by e.id")
	public List<Vehiculo> obtenerVehiculos();
	public Optional<Vehiculo> findByPatente(String patente);
	
	

}
