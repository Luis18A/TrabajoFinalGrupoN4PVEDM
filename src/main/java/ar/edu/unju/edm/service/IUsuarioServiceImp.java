package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.IUsuarioRepository;


@Service
public class IUsuarioServiceImp implements IUsuarioService{

	@Autowired
	IUsuarioRepository iUsuarioRepository;
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		iUsuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario modificar(Usuario usuario) throws Exception{
		Usuario guardarUsuario= encontrarUsuario(usuario.idUsuario);
		mapearUsuario(usuario, guardarUsuario);
		return iUsuarioRepository.save(guardarUsuario);
	}
	public void mapearUsuario(Usuario desde, Usuario hacia) {
		hacia.setNombreReal(desde.getNombreReal());
		hacia.setApellidoReal(desde.getApellidoReal());
		hacia.setNombreUsuario(desde.getNombreUsuario());
		hacia.setPassword(desde.getPassword());
		hacia.setTipoUsuario(desde.getTipoUsuario());
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return iUsuarioRepository.obtenerUsuarios();
	}
	@Override
	public Usuario encontrarUsuario(Long idUsuario) throws Exception{
		return iUsuarioRepository.findById(idUsuario).orElseThrow(()-> new Exception("El usuario no existe"));
	}

	@Override
	public void eliminar(Long idUsuario) {
		// TODO Auto-generated method stub
		iUsuarioRepository.deleteById(idUsuario);
	}
	
	@Override
	public Iterable<Usuario> listarTodos() {
		// TODO Auto-generated method stub
		return iUsuarioRepository.findAll();
	}
}
