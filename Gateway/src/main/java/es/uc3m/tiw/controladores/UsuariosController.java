package es.uc3m.tiw.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.dominio.Usuario;

@Controller
public class UsuariosController {
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping(value="/registrar")
	public String registrarUsuarios(Model modelo){
		Usuario u=new Usuario();
		modelo.addAttribute(u);
		return "registro";
	}
	
	@PostMapping("/registrar")
	public String guardarUnUsuario(Model modelo, @ModelAttribute Usuario usuario){
		System.out.println(usuario);
		Usuario usuarioGuardado = restTemplate.postForObject("http://localhost:8010/registro", usuario, Usuario.class);
		modelo.addAttribute(usuarioGuardado);
		return "index";
		
	}
	
	@PostMapping("/loguear")
	public String validarUsuario(Model modelo, @ModelAttribute Usuario usuario){
		System.out.println(usuario);
		Usuario usuarioValidado = restTemplate.postForObject("http://localhost:8010/login", usuario, Usuario.class);
		modelo.addAttribute("usuarioValidado",usuarioValidado);
		modelo.addAttribute("logueado", true);
		return "perfilUsuario";
		
	}
	@RequestMapping(value="/perfilUsuario",method=RequestMethod.GET)
	public String verUsuario(Model modelo, @ModelAttribute Usuario usuario){
		System.out.println(usuario);
		return "perfilUsuario";
		
	}
	
}
