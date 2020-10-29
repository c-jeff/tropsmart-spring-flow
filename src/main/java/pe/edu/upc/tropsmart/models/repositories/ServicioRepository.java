package pe.edu.upc.tropsmart.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tropsmart.models.entities.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer>{
	List<Servicio> findByEstado(String estado) throws Exception;
}
