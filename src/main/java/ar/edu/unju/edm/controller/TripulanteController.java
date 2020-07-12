package ar.edu.unju.edm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	// ESTO ES LO QUE YA NO VA PORQUE ESTA PUESTO EN EL REGISTROTRACKINGCONTROLLER, AHI SE CREA EL TRIPULANTE (new tripulante)
	// al final funciona asi, sin lo del comentario de arriba
	
	@PostMapping("/saveTripulante")
	public String guardarT(@ModelAttribute Tripulante tripulante, Model model) {
		tripulanteService.guardarTripulante(tripulante);
		return "redirect:/agregarRegistro";
	}
	
	
//	@PostMapping("/buscarTripulante")
//	public String buscarT(@ModelAttribute Tripulante tripulante, Model model) {
//		Tripulante tripulanteEncontrado = tripulanteService.buscarTripulante(tripulante.getDocumento());
//		try{
//			 tripulanteService.guardarTripulanteEncontrado(tripulanteEncontrado);
//		}catch(Exception e){
//			model.addAttribute("formTripulanteErrorMessage", e.getMessage());							
//		}
//		return agregarR(model);
//	}
	//TODOESTO ESTA EN EL REGISTROTRACKINGCONTROLLER FIJARSE
	//ver video de muchos a muchos por el tema de try catch, falta eso
	
	@GetMapping("/tripulante")
	public String mostrarTripulantes(Model model){
		model.addAttribute("tripulantes",tripulanteService.obtenerTripulantes());
		return "tripulante";	
	}
	@GetMapping("/nuevoTripulante/volver")
	public String cancelarRegistro(ModelMap model){
		return "redirect:/agregarRegistro";
	}
	

	
}
