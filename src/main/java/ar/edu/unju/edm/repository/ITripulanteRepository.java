package ar.edu.unju.edm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Tripulante;

@Repository
public interface ITripulanteRepository extends JpaRepository<Tripulante,Long>{

}