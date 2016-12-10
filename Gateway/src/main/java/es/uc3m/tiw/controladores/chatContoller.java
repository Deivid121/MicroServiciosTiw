package es.uc3m.tiw.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import es.uc3m.tiw.dominio.Mensaje;
import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;


@SessionAttributes(value={"logueado","usuarioValidado"})
@Controller
public class chatContoller {
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping(value="/enviarMensaje/{idProducto}/{idPropietario}", method= RequestMethod.GET)
	public String Mensaje(@PathVariable Long idProducto, @PathVariable Long idPropietario,
			@SessionAttribute(value="usuarioValidado")Usuario u, Model modelo){
		modelo.addAttribute("idProducto",idProducto);
		modelo.addAttribute("idPropietario",idPropietario);
		Mensaje m = new Mensaje();
		modelo.addAttribute("mensaje",m);
		return "enviarMensaje";
	}
	@PostMapping(value="/enviarMensaje/{idProducto}/{idPropietario}")
	public String guardarMensaje(@PathVariable Long idProducto, @PathVariable Long idPropietario,
			@SessionAttribute(value="usuarioValidado")Usuario u, @ModelAttribute Mensaje mensaje){
		mensaje.setDestinoId(idPropietario);
		mensaje.setOrigenId(u.getId());
		mensaje.setProductoId(idProducto);
		System.out.println(mensaje);
		Mensaje m=restTemplate.postForObject("http://localhost:8030/enviarMensaje", mensaje, Mensaje.class);
		return "/index";
		
	}
	@RequestMapping(value="/bandejaEntrada")
	public String Entrada(){
		return "bandejaEntrada";
	}
}
