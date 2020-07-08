package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		String pw = usuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setPassword(bCryptPasswordEncoder.encode(pw));
		iUsuarioRepository.save(usuario);
	}
	
	@Override
	public List<Usuario> obtenerUsuarios() {
		return iUsuarioRepository.obtenerUsuarios();
	}

	
	
	//modificacion y eliminacion
	@Override
	public Usuario modificar(Usuario unUsuario) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioGuardar = encontrarUsuario(unUsuario.idUsuario);
		mapearUsuario(unUsuario, usuarioGuardar);
		return iUsuarioRepository.save(usuarioGuardar);
	}
	public void mapearUsuario(Usuario desde, Usuario hacia) {
		hacia.setNombreReal(desde.getNombreReal());
		hacia.setApellidoReal(desde.getApellidoReal());
		hacia.setNombreUsuario(desde.getNombreUsuario());
		//hacia.setPassword(desde.getPassword());
		hacia.setTipoUsuario(desde.getTipoUsuario());
	}
	

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		iUsuarioRepository.deleteById(id);
	}

	@Override
	public Usuario encontrarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return iUsuarioRepository.findById(id).orElseThrow(()-> new Exception("El usuario no existe"));
	}
}
