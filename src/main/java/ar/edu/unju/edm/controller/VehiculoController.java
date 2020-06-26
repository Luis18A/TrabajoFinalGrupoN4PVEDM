package ar.edu.unju.edm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Vehiculo;

@Controller
@RequestMapping
public class VehiculoController {
	
	
	@GetMapping("/nuevovehiculo")
	public String agregar(Model model) {
		model.addAttribute("vehiculoDelForm",new Vehiculo());
		return "form-vehiculo";
	}
	
	@PostMapping("/nuevovehiculo")
	public String guardar(@ModelAttribute ("vehiculoDelForm") Vehiculo vehiculo, Model model) {
		model.addAttribute(new Vehiculo());
	return "redirect:/form-vehiculo"; 
	}
	
}
