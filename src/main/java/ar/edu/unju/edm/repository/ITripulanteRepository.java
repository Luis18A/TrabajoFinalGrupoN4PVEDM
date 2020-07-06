package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Tripulante;

@Repository
public interface ITripulanteRepository extends JpaRepository<Tripulante,Long>{
	
	@Query("from Tripulante e order by e.id")
	public List<Tripulante> obtenerTripulantes();
	
	public Optional<Tripulante> findByDocumento(String documento);

}