package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Tripulante;
import ar.edu.unju.edm.service.ITripulanteService;

@Controller
@RequestMapping
public class TripulanteController {
	
	@Autowired
	ITripulanteService tripulanteService;
	
	@GetMapping("/nuevoTripulante")
	public String agregarT(Model model) {
		model.addAttribute("tripulanteD", new Tripulante());
		return "tripulanteForm";
	}
	@PostMapping("/saveTripulante")
	public String guardarT(@ModelAttribute Tripulante tripulante, Model model) {
		tripulanteService.guardarTripulante(tripulante);
		return "redirect:/nuevoTripulante";
	}
	
	@GetMapping("/tripulante")
	public String mostrarTripulantes(Model model){
		model.addAttribute("tripulantes",tripulanteService.obtenerTripulantes());
		return "tripulante";	
	}
}
