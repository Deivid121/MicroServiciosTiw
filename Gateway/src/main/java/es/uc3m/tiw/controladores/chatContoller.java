package es.uc3m.tiw.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class chatContoller {
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping(value="/enviarMensaje")
	public String Mensaje(){
		return "enviarMensaje";
	}
	@RequestMapping(value="/bandejaEntrada")
	public String Entrada(){
		return "bandejaEntrada";
	}
}
