package es.uc3m.tiw.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;


import es.uc3m.tiw.dominio.Usuario;

@SessionAttributes(value={"logueado","usuarioValidado"})
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
	
	@RequestMapping(value="/editarUsuario")
	public String editarUsuarios(Model modelo){
		modelo.addAttribute(new Usuario());
		return "editarUsuario";
	}
	@PostMapping("/editar")
	public String actualizarUsuario(Model modelo, @ModelAttribute Usuario usuario){
		System.out.println(usuario);
		Usuario usuarioValidado = restTemplate.postForObject("http://localhost:8010/editarU", usuario, Usuario.class);
		modelo.addAttribute("usuarioValidado",usuarioValidado);
		return "perfilUsuario";
	}
	@RequestMapping(value="/eliminar", method=RequestMethod.GET)
	public String borrarUsuario(Model modelo, HttpServletRequest request){
		HttpSession sesion =request.getSession();
		Usuario usuario = (Usuario)sesion.getAttribute("usuarioValidado");
		
		return usuario.toString();
	}
	
	
	@PostMapping("/loguear")
	public String validarUsuario(Model modelo, @ModelAttribute Usuario usuario, HttpSession sesion){
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
