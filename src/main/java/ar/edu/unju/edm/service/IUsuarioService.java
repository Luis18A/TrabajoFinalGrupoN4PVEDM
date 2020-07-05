package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;

@Service
public interface IUsuarioService {

	public void guardarUsuario(Usuario usuario);
	public List<Usuario> obtenerUsuarios();	
	public Usuario modificar(Usuario unUsuario) throws Exception;
	public void eliminar(Long id);
	public Usuario encontrarUsuario(Long id) throws Exception;
	
	public Iterable<Usuario> listarTodos();
	
}
