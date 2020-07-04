package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	private IUsuarioService usuarioService;
	
	@Autowired
	private Usuario unUsuario;
	
	@GetMapping("/nuevoUsuario")
	public String agregarU(Model model) {
		model.addAttribute("usuarioD",new Usuario());
		return "usuarioForm";
	}
	@GetMapping("/formulario")
	public String cargarFormulario(Model model) {
		model.addAttribute("usuarioDelForm", unUsuario);
		model.addAttribute("listaUsuarios", usuarioService.listarTodos());
		model.addAttribute("formTab", "active");
		return "usuarioForm";
		
	}
	
	@PostMapping("/saveUsuario")
	public String guardarU(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		return "redirect:/nuevoUsuario";
	} 
	
	@GetMapping("/usuario")
	public String mostrarUsuarios(Model model){
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());		
		return "usuario";	
	}
	@GetMapping("/cancelar")
	public String cancelarEditarUsuario(ModelMap model) {
	   return "redirect:/formulario";	
	}
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			usuarioService.eliminar(id);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		return cargarFormulario(model);
	}
	
	@GetMapping("/EditarUsuario/{id}")
	public String ObtenerFormularioEditarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {
		Usuario usuarioEncontrado= usuarioService.encontrarUsuario(id);
		model.addAttribute("usuarioDelForm", usuarioEncontrado);
		model.addAttribute("FormTab","active");
		model.addAttribute("editMode","true");
		return "usuarioForm";
	}
	
	
	@PostMapping("/editarUsuario")
	public String postEditarUsuario(@Validated @ModelAttribute("usuarioDelForm") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usuarioDelForm", usuario);
			model.addAttribute("FormTab", "active");
			model.addAttribute("editMode", "true");
		}else {
			try {
				usuarioService.modificar(usuario);
				model.addAttribute("usuarioDelForm", unUsuario);
				model.addAttribute("FormTab", "active");
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuarioDelForm", usuario);
				model.addAttribute("FormTab", "active");
				model.addAttribute("listaUsuarios", usuarioService.listarTodos());
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("listaUsuarios", usuarioService.listarTodos());
		return "usuarioForm";
	}
}