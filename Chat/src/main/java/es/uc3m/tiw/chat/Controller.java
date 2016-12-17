package es.uc3m.tiw.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping (value="/bandejaEntrada/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Mensaje> bandejaEntrada(@PathVariable Long id){
		 return (List<Mensaje>) dao.findByDestinoId(id);
	}
	
	@RequestMapping(value="/eliminarM/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void eliminarMensaje(@PathVariable long id){
        dao.delete(id); 
    }
	
	@RequestMapping (value="/buscarTodos/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Mensaje> buscarTodos(@PathVariable Long id){
		 return (List<Mensaje>) dao.findByDestinoIdOrOrigenId(id,id);
	}
	@RequestMapping (value="/buscarTodosP/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Mensaje> buscarTodosP(@PathVariable Long id){
		 return (List<Mensaje>) dao.findByProductoId(id);
	}
	
}
