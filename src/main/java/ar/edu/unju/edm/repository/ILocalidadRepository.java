package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Localidad;


@Repository
public interface ILocalidadRepository extends JpaRepository<Localidad,Long>{

	@Query("from Localidad e order by e.id")
	public List<Localidad> obtenerLocalidades();
}
