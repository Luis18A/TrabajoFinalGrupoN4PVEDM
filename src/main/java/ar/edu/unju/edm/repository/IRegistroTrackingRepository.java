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
	//Query("from RegistroTracking e order by e.vehiculo")	
	//@Query("select e from RegistroTracking e order by e.fechaHora")	

	@Query("SELECT a FROM RegistroTracking a WHERE a.vehiculo.id = :id")	
	List<RegistroTracking> findByIdVehiculoOrderByFechaHoraAsc(@Param("id") Long id);
}
