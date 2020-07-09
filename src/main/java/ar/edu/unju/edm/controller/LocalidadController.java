package ar.edu.unju.edm.controller;

import javax.validation.Valid;

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

import ar.edu.unju.edm.model.Localidad;
import ar.edu.unju.edm.service.ILocalidadService;

@Controller 
@RequestMapping
public class LocalidadController {
	
	@Autowired
	ILocalidadService localidadService;
	@Autowired
	Localidad unaLocalidad;
	
	@GetMapping("/nuevaLocalidad")
	public String agregarL(Model model) {
		model.addAttribute("localidadD", unaLocalidad);
		return "localidadForm";
	}
	
	@PostMapping("/saveLocalidad")
	public String guardarL(@ModelAttribute Localidad localidad, Model model) {
		localidadService.guardarLocalidad(localidad);
		model.addAttribute("localidadD", unaLocalidad);
		return "redirect:/localidad"; 
	}
	
	@GetMapping("/localidad")
	public String mostrarLocalidades(Model model){
		model.addAttribute("localidades", localidadService.obtenerLocalidades());
		return "localidad";	
	}
	
	
	
	//modificar y eliminar
	@GetMapping("/editarLocalidad/{id}")
	public String ObtenerFormularioEditarLocalidad(Model model, @PathVariable(name="id") Long id) throws Exception {
		Localidad localidadEncontrada = localidadService.encontrarLocalidad(id);
		model.addAttribute("localidadD", localidadEncontrada);
		//model.addAttribute("localidades", usuarioService.obtenerUsuarios());
		model.addAttribute("editMode","true");

		return "localidadForm";
	}
	
	
	@PostMapping("/editarLocalidad")
	public String postEditarLocalidad(@Valid @ModelAttribute("localidadD") Localidad localidad, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("localidadD", localidad);
			model.addAttribute("editMode", "true");
		}else {
			try {
				localidadService.modificar(localidad);
				model.addAttribute("localidadD", unaLocalidad);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				//pasar las excepciones al hmtl
				model.addAttribute("formLocalidadErrorMessage", e.getMessage());
				model.addAttribute("localidadForm", localidad);
				//model.addAttribute("localidades", usuarioService.obtenerUsuarios());
				model.addAttribute("editMode", "true");
			}
		}
		//model.addAttribute("localidades", localidadService.obtenerLocalidades());
		return "redirect:/localidad";
	}
	
	
	@GetMapping("/eliminarLocalidad/{id}")
	public String eliminarLocalidad(Model model, @PathVariable(name="id") Long id) {
		try {
			localidadService.eliminar(id);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return mostrarLocalidades(model);
		
	}
	
	
	@GetMapping("/cancelarL")
	public String cancelarEditarLocalidad(ModelMap model) {
		//CAMBIOreturn "redirect:/nuevaLocalidad"; VER
		return "redirect:/localidad";		
	}
}
