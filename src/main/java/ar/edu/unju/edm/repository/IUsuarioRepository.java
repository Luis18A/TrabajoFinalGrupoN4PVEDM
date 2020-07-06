package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ar.edu.unju.edm.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long>{

	@Query("from Usuario e order by e.id")
	public List<Usuario> obtenerUsuarios();
	
	public Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}