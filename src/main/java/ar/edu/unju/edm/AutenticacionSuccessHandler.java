package ar.edu.unju.edm;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutenticacionSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean tipoRegistrador = false;
		boolean tipoConsultor = false;
		boolean tipoBd = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("Registrador")) {
				tipoRegistrador = true;
				
				break;
			}else {
				if(grantedAuthority.getAuthority().equals("Consultor")) {
					tipoConsultor = true;
					break;
				}else {
					tipoBd = true;
					break;
			}
				
			}
		}
		if(tipoRegistrador) {
			redirectStrategy.sendRedirect(request, response, "/agregarRegistro");
		}else {
			if(tipoConsultor) {
				redirectStrategy.sendRedirect(request, response, "/consultas");
			}else {
				if(tipoBd) {
					redirectStrategy.sendRedirect(request, response, "/usuario");
				}else {
					throw new IllegalStateException();
				}
			}
		}
	}
}