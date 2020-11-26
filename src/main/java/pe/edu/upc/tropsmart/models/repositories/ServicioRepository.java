package pe.edu.upc.tropsmart.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tropsmart.models.entities.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer>{
	List<Servicio> findByEstado(String estado) throws Exception;
	@Query("select s from Servicio s where s.cliente.id = ?1 and s.estado = ?2")
	List<Servicio> findByClienteAndEstado(Integer id, String estado) throws Exception;
}
