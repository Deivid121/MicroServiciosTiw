package es.uc3m.tiw.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import es.uc3m.tiw.dominio.MensajeMostrado;
import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;
import groovy.util.ObjectGraphBuilder.NewInstanceResolver;


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
	@RequestMapping(value="/bandejaEntrada", method= RequestMethod.GET)
	public String Entrada(@SessionAttribute(value="usuarioValidado")Usuario u, Model modelo){
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("id", u.getId());
		ResponseEntity responseEntity =  restTemplate.getForEntity("http://localhost:8030/bandejaEntrada/{id}",
				Mensaje[].class, vars);
		Mensaje m[] = (Mensaje[])responseEntity.getBody();
		List <Mensaje> mensajes = Arrays.asList(m);
		List <MensajeMostrado> mensajesMostrados = new ArrayList<MensajeMostrado>();
		for(int i=0;i<mensajes.size();i++){
			Map<String,Long> varUser = new HashMap<String,Long>();
			varUser.put("userId", mensajes.get(i).getOrigenId());
			Usuario user = restTemplate.getForObject("http://localhost:8010/buscarPorId/{userId}", Usuario.class,varUser);
			
			Map<String,Long> varProd = new HashMap<String,Long>();
			varProd.put("prodId", mensajes.get(i).getProductoId());
			Producto prod = restTemplate.getForObject("http://localhost:8020/buscarPorId/{prodId}", Producto.class,varProd);
			MensajeMostrado mM = new MensajeMostrado(mensajes.get(i).getId(),prod.getUsuario(),prod.getId(), user.getNombre(),
					prod.getTitulo(), mensajes.get(i).getMensaje());
			
			mensajesMostrados.add(mM);
		}
		modelo.addAttribute("listaMensajes", mensajesMostrados);
		return "bandejaEntrada";
	}
}
