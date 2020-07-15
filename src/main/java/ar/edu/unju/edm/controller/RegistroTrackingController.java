package ar.edu.unju.edm.controller;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.ConsultaFecha;
import ar.edu.unju.edm.model.Localidad;
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
	@Autowired
	ConsultaFecha consulta;
	
	@GetMapping("/agregarRegistro")
	public String agregarR(Model model) {	
		model.addAttribute("registroTrackingD", new RegistroTracking());
		model.addAttribute("tripulantes",tripulanteService.obtenerTripulantes());
		model.addAttribute("tripulanteD", new Tripulante());
		//bandera
		model.addAttribute("editMode", "false");
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
	//Cmbiar bandera a true
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
			//bandera true
		}
		
		return agregarR(model);
	}
	
	@GetMapping("/agregarRegistro/cancelar")
	public String cancelarRegistro(ModelMap model){
		tripulanteService.borrarTripulantes();
		vehiculoService.borrarVehiculoA();
		return "redirect:/agregarRegistro";
	}
	
	
	//agregado
	@GetMapping("/consultas")
	public String consultar(Model model){
		Vehiculo unVehiculo = new Vehiculo();
		model.addAttribute("vehiculoD", unVehiculo);
		Tripulante tripulante = new Tripulante();
		model.addAttribute("tripulanteD", tripulante);
		//agregado2
		Localidad unaLocalidad = new Localidad();
		model.addAttribute("localidadD", unaLocalidad);
		ConsultaFecha unaConsulta = new ConsultaFecha();
		model.addAttribute("consulta",unaConsulta);	
		return "consultas";
	}
	
	
	//agregado
	@PostMapping("/buscarListadoPatente")
	public String buscarListadoPatente(@ModelAttribute Vehiculo vehiculo, Model model) throws Exception{
		try{
			Vehiculo vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
			try{
				Long id = vehiculoService.devolverIdPatente(vehiculoEncontrado);
				model.addAttribute("registrosTrackingO",registroTrackingService.obtenerRegistros(id));				
//				model.addAttribute("registrosTrackingO",vehiculoService.obtenerRegistros(id));
				//vehiculoService.listarRegistros(id);
			}catch(Exception e){
				model.addAttribute("formVehiculoErrorMessage", e.getMessage());							
			}
		}catch(Exception e){
			model.addAttribute("formVehiculo1ErrorMessage", e.getMessage());
			return consultar(model);
		}
		
		return "consultaTres";
	}
		
	
	
	

	
	//agregado Buscar tripulante por documento
	@PostMapping("/buscarListadoDocumento")
	public String buscarListadoTripulante(@ModelAttribute("tripulanteD") Tripulante tripulante, Model model) throws Exception{
		try{
			Tripulante tripulanteEncontrado = tripulanteService.buscarTripulante(tripulante.getDocumento());
			try{
				model.addAttribute("registrosTrackingCD",registroTrackingService.obtenerRegistrosCD(tripulanteEncontrado));				
//				for (int i=1;i<=tripulanteEncontrado.getRegistrosT().size() ;i++){
//					System.out.println(tripulanteEncontrado.getRegistrosT().get(i).getIdRegistro());
//				}
				//Long id = tripulanteService.devolverIdTripulante(tripulanteEncontrado);
				//System.out.println(id);
				//model.addAttribute("oT",registroTrackingService.obtenerRegistrosT(id));				
				//model.addAttribute("registrosTrackingO",vehiculoService.obtenerRegistros(id));
				//vehiculoService.listarRegistros(id);
			}catch(Exception e){
				model.addAttribute("formTripulanteErrorMessage", e.getMessage());							
			}
		}catch(Exception e){
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
			return consultar(model);
		}
		return "consultaDos";
	}
	
	
	
		
		
		//agregado2
		@PostMapping("/buscarListadoLocalidad")
		public String buscarListadoLocalidad(@ModelAttribute ("localidadD") Localidad localidad, @ModelAttribute ("consulta") ConsultaFecha consulta, Model model) throws Exception{
			
			try{
				Localidad localidadEncontrada = localidadService.buscarLocalidad(localidad.getNombre());
				try{
					
					consulta = registroTrackingService.obtenerFechas();
					Long id = localidadService.devolverIdLocalidad(localidadEncontrada);
					LocalDateTime date1 = consulta.getFechaHora1().atStartOfDay();
					LocalDateTime date2 = consulta.getFechaHora2().atStartOfDay();
					//LocalDateTime date1 = LocalDateTime.of(2020,07,8,00,00,00);
					//LocalDateTime date2 = LocalDateTime.of(2020,07,12,00,00,00);
//					System.out.println(id);
//					System.out.println(date1);
//					System.out.println(date2);
					model.addAttribute("registrosTrackingOL",registroTrackingService.obtenerRegistrosOL( date1, date2, id));				
				}catch(Exception e){
					model.addAttribute("formLocalidadErrorMessage", e.getMessage());							
				}
			}catch(Exception e){
				model.addAttribute("formLocalidadErrorMessage", e.getMessage());
			}
			
			return "consultaUno";
		}
		
		@PostMapping("/buscarFechas")
		public String buscarFechas(@ModelAttribute ("consulta") ConsultaFecha consulta, Model model){
			 registroTrackingService.guardarFechas(consulta);
			return consultar(model);
		}
		
		
}