package es.uc3m.tiw.control;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.dominio.Mensaje;
import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.repository.ProductoRepository;

@RestController
public class controlProducto {
 private Producto p;
	
 @Autowired
 private ProductoRepository rep;
 @Autowired
 RestTemplate restTemplate;
 

 @RequestMapping(value="/subirProducto" ,method = RequestMethod.POST)
 public  @ResponseBody Producto crear(@RequestBody Producto producto){
     Producto p=rep.save(producto);
     System.out.println(p);
     return p;
 }

 @RequestMapping(value="/getProductos" , method = RequestMethod.GET)
 public @ResponseBody List<Producto> productos(){
	 return rep.findAll();
 }
 @RequestMapping(value = "/buscarProducto/{busqueda}" ,method = RequestMethod.GET)
 public @ResponseBody List<Producto> buscar(@PathVariable String busqueda){
	 return rep.findByTituloContainingOrDescripcionContaining(busqueda, busqueda);
 }
 
 @RequestMapping(value = "/verProducto/{id}" ,method = RequestMethod.GET)
 public @ResponseBody Producto buscarProducto(@PathVariable long id){
	 return rep.findById(id);
 }
 @RequestMapping(value = "/modificarProducto" ,method = RequestMethod.PUT)
 public @ResponseBody Producto modificarProducto(@RequestBody Producto p){ 
	 return  rep.save(p);
 }
 @RequestMapping(value="/eliminarP/{id}", method = RequestMethod.DELETE)
 public @ResponseBody void eliminarUsuario(@PathVariable long id){
	 Map <String, Long>vars= new HashMap<String, Long>();
     vars.put("id", id);
     ResponseEntity responseEntity=restTemplate.getForEntity("http://localhost:8030/buscarTodosP/{id}", Mensaje[].class, vars);
     Mensaje[]prod=(Mensaje[])responseEntity.getBody();
     List<Mensaje> lista= Arrays.asList(prod);
     for(int i = 0; i < lista.size(); i++){
    	 vars.put("id", (long) lista.get(i).getId());
    	 restTemplate.delete("http://localhost:8030/eliminarM/{id}",vars);
     }   
     rep.delete(id); 
 }
 @RequestMapping(value="/buscarPorId/{id}", method = RequestMethod.GET)
 public @ResponseBody Producto buscarUsuario(@PathVariable Long id){
	 return rep.findById(id);
    
 }
 @RequestMapping(value="/verMisProductos/{id}", method = RequestMethod.GET)
 public @ResponseBody List<Producto> verMisProductos(@PathVariable long id){
	 
	 return rep.findByUsuario((int)id);
    
 }
 
}