package ar.edu.unju.edm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.service.IUsuarioService;
//implemento del errorcontroller
@Controller
public class MainController implements ErrorController{
	
	@Autowired
	IUsuarioService usuarioService;
	
	//Declaraciondevariablepararedirigirelerror
	private static final String PATH="/error";
	
	@RequestMapping("/home") 
	public String main(Model model) {
		return "home";
	}
	
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "login";
	}
	
	@GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
          
        return "redirect:/login?logout";
    }
	//vista base de datos
	//@GetMapping("/vistaBd")
	//public String vistaBd(Model model) {
	//	return "vistaBd";
	//}
	
	//Valor que retorna en este caso el html error
	@RequestMapping(value=PATH)
	public String defaultErrorMessage() {
		return "error";
	}
	
	//agrego el metodo errorpath
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}