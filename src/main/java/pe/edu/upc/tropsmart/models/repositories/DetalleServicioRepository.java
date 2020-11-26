package pe.edu.upc.tropsmart.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tropsmart.models.entities.DetalleServicio;

@Repository
public interface DetalleServicioRepository extends JpaRepository<DetalleServicio, Integer>{
	@Query("select d from DetalleServicio d where d.servicio.transportista.id = ?1 and d.servicio.estado <> ?2")
	List<DetalleServicio> findByTransportistaAndNotEstado(Integer id, String estado) throws Exception;
}
