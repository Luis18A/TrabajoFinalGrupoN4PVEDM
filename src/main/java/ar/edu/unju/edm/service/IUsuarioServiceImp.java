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
	public List<Usuario> obtenerUsuarios() {
		return iUsuarioRepository.obtenerUsuarios();
	}
}
