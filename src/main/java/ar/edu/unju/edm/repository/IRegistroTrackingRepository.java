package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.RegistroTracking;

@Repository
public interface IRegistroTrackingRepository extends JpaRepository<RegistroTracking,Long>{
	//agregado
	@Query("SELECT a FROM RegistroTracking a WHERE a.vehiculo.id = :id")	
	List<RegistroTracking> findByIdTripulanteOrderByFechaHoraAsc(@Param("id") Long id);
	@Query("SELECT a FROM RegistroTracking a WHERE a.vehiculo.id = :id")	
	List<RegistroTracking> findByIdVehiculoOrderByFechaHoraAsc(@Param("id") Long id);
}
