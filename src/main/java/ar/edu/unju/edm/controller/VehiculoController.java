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

import ar.edu.unju.edm.model.Vehiculo;
import ar.edu.unju.edm.service.IVehiculoService;
@Controller
@RequestMapping
public class VehiculoController {
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private Vehiculo unVehiculo;
	
	@GetMapping("/nuevoVehiculo")
	public String agregarU(Model model) {
		model.addAttribute("VehiculoD",new Vehiculo());
		return "VehiculoForm";
	}
	@GetMapping("/formulario")
	public String cargarFormulario(Model model) {
		model.addAttribute("VehiculoDelForm", unVehiculo);
		model.addAttribute("listaVehiculos", Vehiculo.listarTodos());
		model.addAttribute("formTab", "active");
		return "VehiculoForm";
		
	}
	
	@PostMapping("/saveVehiculo")
	public String guardarU(@ModelAttribute Vehiculo vehiculo, Model model) {
		vehiculoService.guardarVehiculo(vehiculo);
		return "redirect:/nuevoUsuario";
	} 
	
	@GetMapping("/Vehiculo")
	public String mostrarVehiculo(Model model){
		model.addAttribute("Vehiculos", vehiculoService.obtenerVehiculo());		
		return "usuario";	
	}
	@GetMapping("/cancelar")
	public String cancelarEditarVehiculo(ModelMap model) {
	   return "redirect:/formulario";	
	}
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			vehiculoService.eliminar(id);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		return cargarFormulario(model);
	}
	
	@GetMapping("/EditarVehiculo/{id}")
	public String ObtenerFormularioEditarVehiculo(Model model, @PathVariable(name="id") Long id) throws Exception {
		Vehiculo vehiculoEncontrado= vehiculoService.encontrarVehiculo(id);
		model.addAttribute("VehiculoDelForm", vehiculoEncontrado);
		model.addAttribute("FormTab","active");
		model.addAttribute("editMode","true");
		return "VehiculoForm";
	}


	@PostMapping("/editarVehiculo")
	public String postEditarVehiculo(@Validated @ModelAttribute("VehiculoDelForm") Vehiculo vehiculo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("VehiculoDelForm", vehiculo);
			model.addAttribute("FormTab", "active");
			model.addAttribute("editMode", "true");
		}else {
			try {
				vehiculoService.modificar(vehiculo);
				model.addAttribute("VehiculoDelForm", unVehiculo);
				model.addAttribute("FormTab", "active");
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formVehiculoErrorMessage", e.getMessage());
				model.addAttribute("VehiculoDelForm", vehiculo);
				model.addAttribute("FormTab", "active");
				model.addAttribute("listaVehiculos", vehiculoService.listarTodos());
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("listaVehiculo", vehiculoService.listarTodos());
		return "VehiculoForm";
	}
}