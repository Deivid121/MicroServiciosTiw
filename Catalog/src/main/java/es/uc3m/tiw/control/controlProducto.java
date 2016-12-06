package es.uc3m.tiw.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.repository.ProductoRepository;

@RestController
public class controlProducto {
 private Producto p;
	
 @Autowired
 private ProductoRepository rep;
 
 @RequestMapping(value="/subirProducto" ,method = RequestMethod.POST)
 public  @ResponseBody Producto login(@RequestBody Producto p){
     rep.save(p);
     return p;
 }
 @RequestMapping(value="/subirPrueba" ,method = RequestMethod.POST)
 public  @ResponseBody Producto login(){
	 p = new Producto("titulo", "categoria", "descripcion", "imagen", 0,0, "ciudad", "disponible");
     rep.save(p);
     p = new Producto("t1", "c1", "d1", "imagen", 1,1, "c1", "d1");
     rep.save(p);
     p = new Producto("t2", "c2", "d2", "imagen", 2,2, "c2", "d2");
     rep.save(p);
     
     return p;
 }
 @RequestMapping(value="/mostrarProductos" , method = RequestMethod.GET)
 public @ResponseBody List<Producto> productos(){
	 return rep.findAll();
 }
 @RequestMapping(value = "/buscarProducto" ,method = RequestMethod.GET)
 public @ResponseBody List<Producto> buscar(@RequestParam(value ="titulo")String titulo,@RequestParam(value ="descripcion")String descripcion){
	 return rep.findByTituloContainingOrDescripcionContaining(titulo, descripcion);
 }
 
 @RequestMapping(value = "/verProducto" ,method = RequestMethod.GET)
 public @ResponseBody Producto buscarProducto(@RequestBody Producto p){
	 return rep.findById(p.getId());
 }
 @RequestMapping(value = "/modificarProducto" ,method = RequestMethod.PUT)
 public @ResponseBody Producto modificarProducto(@RequestBody Producto p){ 
	 return  rep.save(p);
 }
 
}