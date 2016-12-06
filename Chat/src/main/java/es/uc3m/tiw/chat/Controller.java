package es.uc3m.tiw.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.uc3m.tiw.dominio.Mensaje;
import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;
import es.uc3m.tiw.repository.MensajeDao;

public class Controller {
	@Autowired
	private MensajeDao dao;
	@RequestMapping(value="/registro", method = RequestMethod.POST)
    public @ResponseBody Mensaje registro(@RequestBody Mensaje m){
        dao.save(m);
        return m;
    }
}
