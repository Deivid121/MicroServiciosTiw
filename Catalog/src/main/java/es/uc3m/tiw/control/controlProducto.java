package es.uc3m.tiw.control;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
     rep.delete(id); 
 }
 @RequestMapping(value="/buscarPorId/{id}", method = RequestMethod.GET)
 public @ResponseBody Producto buscarUsuario(@PathVariable Long id){
	 return rep.findById(id);
    
 }
}