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
	public String agregarV(Model model) {
		model.addAttribute("vehiculoD" ,new Vehiculo());
		return "vehiculoForm";
	}
	
	@PostMapping("/saveVehiculo")
	public String guardarV(@ModelAttribute Vehiculo vehiculo, Model model) {
		vehiculoService.guardarVehiculo(vehiculo);
		return "redirect:/agregarRegistro"; 
	}
	
	@GetMapping("/vehiculo")
	public String mostrarVehiculos(Model model){
		model.addAttribute("vehiculos", vehiculoService.obtenerVehiculos());
		return "vehiculo";	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	consulta3
//	@PostMapping("/buscarListadoPatente")
//	public String buscarListadoPatente(@ModelAttribute RegistroTracking registroTracking, Vehiculo vehiculo, Model model) throws Exception{
//		try{
//			Vehiculo vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
//			try{
//				Long id = vehiculoService.devolverIdPatente(vehiculoEncontrado);
//				vehiculoService.listarRegistros(id);
//			}catch(Exception e){
//				model.addAttribute("formVehiculoErrorMessage", e.getMessage());							
//			}
//		}catch(Exception e){
//			model.addAttribute("formVehiculoErrorMessage", e.getMessage());
//		}
//		
//		return "consultaTres";
//	}
	
	
	
	
	
	
}