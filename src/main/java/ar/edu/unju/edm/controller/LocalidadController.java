package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Localidad;
import ar.edu.unju.edm.service.ILocalidadService;

@Controller
@RequestMapping
public class LocalidadController {
	
	@Autowired
	ILocalidadService localidadService;
	
	@GetMapping("/nuevaLocalidad")
	public String agregarL(Model model) {
		model.addAttribute("localidadD", new Localidad());
		return "localidadForm";
	}
	
	@PostMapping("/saveLocalidad")
	public String guardarL(@ModelAttribute Localidad localidad, Model model) {
		localidadService.guardarLocalidad(localidad);
		return "redirect:/nuevaLocalidad"; 
	}
	
}
