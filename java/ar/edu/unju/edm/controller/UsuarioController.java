package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/nuevoUsuario")
	public String agregarU(Model model) {
		model.addAttribute("usuarioD",new Usuario());
		return "usuarioForm";
	}
	@PostMapping("/saveUsuario")
	public String guardarU(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		return "redirect:/nuevoUsuario";
	} 
}