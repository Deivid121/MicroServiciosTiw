package es.uc3m.tiw.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominio.Mensaje;


public interface MensajeDao extends JpaRepository<Mensaje, Long>{
	ArrayList<Mensaje> findByOrigenIdAndDestinoIdAndProductoId (long origenId, long destinoId, long productoId);
	
}
