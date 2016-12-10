package es.uc3m.tiw.chat;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.dominio.Mensaje;
import es.uc3m.tiw.repository.MensajeDao;
@RestController
public class Controller {
	@Autowired
	private MensajeDao dao;
	@RequestMapping(value="/enviarMensaje", method = RequestMethod.POST)
    public @ResponseBody Mensaje enviar(@RequestBody Mensaje m){
        dao.save(m);
        return m;
    }
	@RequestMapping(value="/recibirMensaje", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Mensaje> recibir(@RequestParam(value="origenId", required = true) long oId,
            @RequestParam(value="destinoId", required = true) long dId,
            @RequestParam(value="productoId", required = true) long pId){
		return dao.findByOrigenIdAndDestinoIdAndProductoId(oId, dId, pId);
		
	}
}
