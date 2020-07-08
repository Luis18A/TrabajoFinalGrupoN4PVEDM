package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.RegistroTracking;
import ar.edu.unju.edm.model.Tripulante;
import ar.edu.unju.edm.model.Vehiculo;
import ar.edu.unju.edm.service.ILocalidadService;
import ar.edu.unju.edm.service.IRegistroTrackingService;
import ar.edu.unju.edm.service.ITripulanteService;
import ar.edu.unju.edm.service.IVehiculoService;

@Controller
@RequestMapping
public class RegistroTrackingController {
	
	@Autowired
	IVehiculoService vehiculoService;
	@Autowired
	ITripulanteService tripulanteService;
	@Autowired
	IRegistroTrackingService registroTrackingService;
	@Autowired
	ILocalidadService localidadService;
	//Vehiculo unVehiculo;
	
	@GetMapping("/agregarRegistro")
	public String agregarR(Model model) {	
		model.addAttribute("registroTrackingD", new RegistroTracking());
		model.addAttribute("tripulantes",tripulanteService.obtenerTripulantes());
		model.addAttribute("tripulanteD", new Tripulante());
		//tuve que crearlo asi para que saliera la tabla de vehiculo, "unVehiculo" paso como parametro.
		Vehiculo unVehiculo = new Vehiculo();
		model.addAttribute("vehiculoD", unVehiculo);
		model.addAttribute("localidades", localidadService.obtenerLocalidades());
		model.addAttribute("vehiculo",vehiculoService.obtenerVehiculo(unVehiculo));


		return "registroTrackingForm";
	}
	

	@PostMapping("/agregarRegistro")
	public String guardarR(@ModelAttribute("registroTrackingD") RegistroTracking registroTracking, Vehiculo vehiculoD, Model model) {
			registroTracking.setTripulantes(tripulanteService.obtenerTripulantes());
			registroTracking.setVehiculo(vehiculoService.obtenerVehiculo(vehiculoD));
			model.addAttribute("vehiculo",vehiculoService.obtenerVehiculo(vehiculoD));

			try {				
				registroTrackingService.guardarRegistroTracking(registroTracking);		
			} catch (Exception e) {
				// TODO Auto-generated catch block			
				model.addAttribute("formRegistroTrackingErrorMessage", e.getMessage());				
			}	
			
			tripulanteService.borrarTripulantes();
			vehiculoService.borrarVehiculoA();
			
//			noticia.setAutores(vehiculoService.obtenerVehiculos());
//			try {				
//				iNoticiaService.guardarNoticia(noticia);		
//			} catch (Exception e) {
//				// TODO Auto-generated catch block			
//				model.addAttribute("formAutorErrorMessage", e.getMessage());				
//			}	
//		iAutorService.borrarTodosAutores();

		return "redirect:/agregarRegistro";
	}
	
	
	@PostMapping("/buscarTripulante")
	public String buscarT(@ModelAttribute Tripulante tripulante, Model model) throws Exception{
		try{
			Tripulante tripulanteEncontrado = tripulanteService.buscarTripulante(tripulante.getDocumento());
			try{
				 tripulanteService.guardarTripulanteEncontrado(tripulanteEncontrado);
			}catch(Exception e){
				model.addAttribute("formTripulanteErrorMessage", e.getMessage());							
			}
		}catch(Exception e){
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		
		return agregarR(model);
	}
	
	@PostMapping("/buscarVehiculo")
	public String buscarV(@ModelAttribute Vehiculo vehiculo, Model model) throws Exception{
		try{
			Vehiculo vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
			try{
				 vehiculoService.guardarVehiculoEncontrado(vehiculoEncontrado);
			}catch(Exception e){
				model.addAttribute("formVehiculoErrorMessage", e.getMessage());							
			}
		}catch(Exception e){
			model.addAttribute("formVehiculoErrorMessage", e.getMessage());
		}
		
		return agregarR(model);
	}
	
	@GetMapping("/agregarRegistro/cancelar")
	public String cancelarRegistro(ModelMap model){
		tripulanteService.borrarTripulantes();
		vehiculoService.borrarVehiculoA();
		return "redirect:/agregarRegistro";
	}
	
}
