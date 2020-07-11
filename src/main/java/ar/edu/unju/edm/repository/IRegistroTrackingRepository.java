package ar.edu.unju.edm.repository;

import java.time.LocalDateTime;
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
	
	//consulta2
//	@Query("SELECT a FROM RegistroTracking a WHERE a.tripulantes = :id")	
//	List<RegistroTracking> findByIdTripulanteOrderByFechaHoraAsc(@Param("id") Long id);	
	//agregado2
	
	//consulta3
	//@Query("SELECT a FROM RegistroTracking a WHERE a.fechaHora > :date1 and a.fechaHora < :date2 and a.localidad.idLocalidad = :id ")
	//List<RegistroTracking> findByLocalidadFechaHoraBetween(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2, @Param("id")Long id);
	//@Query(value = "from EntityClassTable t where yourDate BETWEEN :startDate AND :endDate")
	//public List<EntityClassTable> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	//@Query("SELECT a FROM RegistroTracking a WHERE a.fechaHora >= ?1 and a.fechaHora <= ?2 and a.localidad.idLocalidad = ?3 ")
	//@Query("SELECT a FROM RegistroTracking a WHERE a.localidad.idLocalidad = :id and a.fechaHora >= :date1 and a.fechaHora <= :date2")
	@Query("SELECT a FROM RegistroTracking a WHERE a.localidad.idLocalidad = :id and a.fechaHora between :date1 and :date2")
	List<RegistroTracking> findByFechaHoraBetween(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2, @Param("id") Long id);
	
}
