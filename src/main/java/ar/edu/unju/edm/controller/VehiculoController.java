package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Vehiculo;
import ar.unju.edu.edm.service.IVehiculoService;

@Controller
@RequestMapping
public class VehiculoController {
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private Vehiculo vehiculo;
	
	@GetMapping("/nuevoVehiculo")
	public String agregar(Model model) {
		model.addAttribute("vehiculoDelForm", vehiculo);
		return "form-vehiculo";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Vehiculo vehiculo, Model model) {
			iVehiculoService.guardarVehiculo(vehiculo);
	return "redirect:/form-vehiculo";
	}
	
}
