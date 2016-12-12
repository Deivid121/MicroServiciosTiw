package es.uc3m.tiw.controladores;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;

@Controller
public class ProductosController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/crearProducto", method=RequestMethod.GET)
	public String crearProducto(Model modelo){
		Producto p= new Producto();
		modelo.addAttribute(p);
		return "crearProductos";
	}
	@PostMapping("/crearProducto")
	public String guardarProducto(Model modelo, @ModelAttribute Producto producto,@SessionAttribute(value="usuarioValidado") Usuario usuario, HttpServletResponse response){
		producto.setUsuario(usuario.getId());
		System.out.println(producto);
		Producto productoGuardado = restTemplate.postForObject("http://localhost:8020/subirProducto", producto, Producto.class);
		modelo.addAttribute(productoGuardado);
		try {
			response.sendRedirect("/index");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/index";
	}
	
}
