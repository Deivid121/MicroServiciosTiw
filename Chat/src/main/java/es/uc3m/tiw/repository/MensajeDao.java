package es.uc3m.tiw.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominio.Mensaje;


public interface MensajeDao extends JpaRepository<Mensaje, Long>{
	ArrayList<Mensaje> findByOrigenIdAndDestinoIdAndProductoId (long origenId, long destinoId, long productoId);

	List<Mensaje> findByDestinoId(Long id);
	List<Mensaje> findByDestinoIdOrOrigenId(Long id1, Long id2);
	List<Mensaje> findByProductoId(Long id);
}
