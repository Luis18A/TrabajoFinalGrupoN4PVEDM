package ar.unju.edu.edm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Vehiculo;

@Repository
public interface IVehiculoRepository extends CrudRepository<Vehiculo,Integer>{

}
