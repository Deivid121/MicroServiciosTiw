package es.uc3m.tiw.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.dominio.Administrador;
import es.uc3m.tiw.dominio.Usuario;

@SessionAttributes(value={"adminlogueado","AdminValidado"})
@Controller
public class AdminController {
	@Autowired
	RestTemplate restTemplate;
	
	
//	@PostMapping("/loguear")
//	public String validarUsuario(Model modelo, @ModelAttribute Usuario usuario){
//		System.out.println(usuario);
//		Usuario usuarioValidado = restTemplate.postForObject("http://localhost:8010/login", usuario, Usuario.class);
//		modelo.addAttribute(usuarioValidado);
//		modelo.addAttribute("logueado", true);
//		return "index";
//		
//	}

	
	
	@RequestMapping("/panelAdmin")
	public String validarAdmin(Model modelo, @ModelAttribute Administrador administrador){
		Administrador admin = new Administrador();
		modelo.addAttribute("AdminValidado",admin);
		modelo.addAttribute("logueadoAdmin", false);
		return "LoginAdmin";
		
	}
//	@RequestMapping(value="/perfilUsuario",method=RequestMethod.GET)
//	public String verUsuario(Model modelo, @ModelAttribute Usuario usuario){
//		System.out.println(usuario);
//		return "perfilUsuario";
//		
//	}
	

	@RequestMapping(value="/perfilAdministrador",method=RequestMethod.GET)
	public String verAdmin(Model modelo, @ModelAttribute Administrador administrador){
		System.out.println(administrador);
		return "perfilAdmin";
		
	}
//	@RequestMapping(value="/editarUsuario")
//	public String editarUsuarios(Model modelo){
//		modelo.addAttribute(new Usuario());
//		return "editarUsuario";
//	}
	
	@RequestMapping(value="/editarAdmin")
	public String editarUsuarios(Model modelo){
		modelo.addAttribute(new Administrador());
		return "editarAdmin";
	}
	@PostMapping("/editarA")
	public String actualizarUsuario(Model modelo, @ModelAttribute Usuario usuario){
		System.out.println(usuario);
		Usuario usuarioValidado = restTemplate.postForObject("http://localhost:8010/editarU", usuario, Usuario.class);
		modelo.addAttribute("usuarioValidado",usuarioValidado);
		return "perfilUsuario";
	}
	
}
