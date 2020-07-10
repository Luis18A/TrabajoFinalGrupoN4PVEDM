package ar.edu.unju.edm.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	private Usuario unUsuario;
	
	@GetMapping("/nuevoUsuario")
	public String agregarU(Model model) {
		model.addAttribute("usuarioD",unUsuario);
		return "usuarioForm";
	}
	@PostMapping("/saveUsuario")
	public String guardarU(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		model.addAttribute("usuarioD", unUsuario);
		return "redirect:/usuario";
	} 

	
	@GetMapping("/usuario")
	public String mostrarUsuarios(Model model){
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		return "usuario";	
	}
	
	
	//modificar y eliminar
	@GetMapping("/editarUsuario/{id}")
	public String ObtenerFormularioEditarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {
		Usuario usuarioEncontrado = usuarioService.encontrarUsuario(id);
		model.addAttribute("usuarioD", usuarioEncontrado);
		//model.addAttribute("usuario", usuarioService.obtenerUsuarios());
		model.addAttribute("editMode","true");
		return "usuarioForm";
	}
	
	
	@PostMapping("/editarUsuario")
	public String postEditarUsuario(@ModelAttribute("usuarioD") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
//si da error el objeto recibido se vuelve a enviar a la vista, esta parte es ESPECIFICAMENTE PARA RESTRICCIONES COMO LA CONTRASEÑA DE MINIMO 8 CARACTERES , VER!
			model.addAttribute("usuarioD", usuario);
			model.addAttribute("editMode", "true");
		}else {
			try {
				System.out.println(unUsuario.getIdUsuario());

				usuarioService.modificar(usuario);
				model.addAttribute("usuarioD", unUsuario);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				//pasar las excepciones al hmtl
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("userForm", usuario);
				//model.addAttribute("usuario", usuarioService.obtenerUsuarios());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		return "redirect:/usuario";
	}
	
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			usuarioService.eliminar(id);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return mostrarUsuarios(model);
		
	}
	
	
	@GetMapping("/cancelar")
	public String cancelarEditarUsuario(ModelMap model) {
		//CAMBIOreturn "redirect:/nuevousuario"; VER
		return "redirect:/usuario";	
	}
	
}