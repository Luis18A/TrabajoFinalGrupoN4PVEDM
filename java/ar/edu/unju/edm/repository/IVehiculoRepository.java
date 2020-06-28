package ar.edu.unju.edm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Vehiculo;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long>{

}
