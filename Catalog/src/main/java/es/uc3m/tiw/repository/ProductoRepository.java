package es.uc3m.tiw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominio.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	

}
