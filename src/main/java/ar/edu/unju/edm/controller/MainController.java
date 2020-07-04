package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	@RequestMapping("/home") 
	public String main(Model model) {
		return "home";
	}
	
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "login";
	}
}
