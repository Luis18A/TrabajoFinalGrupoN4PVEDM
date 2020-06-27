package ar.edu.unju.edm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Vehiculo;
import ar.edu.unju.edm.service.IVehiculoService;

@Controller
@RequestMapping
public class VehiculoController {
	
	@Autowired
	IVehiculoService vehiculoService;
	
	/**@RequestMapping("/vehiculos")
	public String getVehiculoForm(Model model) {
	return "index";
	}
	**/
	@GetMapping("/nuevoVehiculo")
	public String agregar(Model model) {
		model.addAttribute("vehiculoD" ,new Vehiculo());
		return "vehiculo";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Vehiculo vehiculo, Model model) {
		vehiculoService.guardarVehiculo(vehiculo);
		return "redirect:/nuevoVehiculo"; 
	}
	
}
