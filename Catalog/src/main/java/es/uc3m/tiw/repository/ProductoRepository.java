package es.uc3m.tiw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominio.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
		List<Producto> findByTituloContaining(String titulo);

}
