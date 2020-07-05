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

import ar.edu.unju.edm.model.Tripulante;
import ar.edu.unju.edm.service.ITripulanteService;

@Controller
@RequestMapping
public class TripulanteController {
	
	@Autowired
	ITripulanteService tripulanteService;
	
	@Autowired
	private Tripulante unTripulante;
	
	@GetMapping("/nuevoTripulante")
	public String agregarT(Model model) {
		model.addAttribute("tripulanteD", new Tripulante());
		return "TripulanteForm";
	}
	
	
	@GetMapping("/formulario")
	public String cargarFormulario(Model model) {
		model.addAttribute("TripualnteDelForm", unTripulante);
		model.addAttribute("listaTripulantes", tripulanteService.listarTodos());
		model.addAttribute("formTab", "active");
		return "TripualnteForm";
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
	
	@GetMapping("/cancelar")
	public String cancelarEditarTripulante(ModelMap model) {
	   return "redirect:/formulario";	
	}
	@GetMapping("/eliminarTripualnte/{id}")
	public String eliminarTripulante(Model model, @PathVariable(name="id") Long id) {
		try {
			tripulanteService.eliminar(id);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		return cargarFormulario(model);
	}
	
	@PostMapping("/editarTripulante")
	public String postEditarTripulante(@Validated @ModelAttribute("TripulanteDelForm") Tripulante tripulante, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("TripulanteDelForm", tripulante);
			model.addAttribute("FormTab", "active");
			model.addAttribute("editMode", "true");
		}else {
			try {
				tripulanteService.modificar(tripulante);
				model.addAttribute("TripulanteDelForm", unTripulante);
				model.addAttribute("FormTab", "active");
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formTripulanteErrorMessage", e.getMessage());
				model.addAttribute("TripulanteDelForm", tripulante);
				model.addAttribute("FormTab", "active");
				model.addAttribute("listaUsuarios", tripulanteService.listarTodos());
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("listaUsuarios", tripulanteService.listarTodos());
		return "TripulanteForm";
	}
}
