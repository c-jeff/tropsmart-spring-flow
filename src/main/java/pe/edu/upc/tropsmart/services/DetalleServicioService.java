package pe.edu.upc.tropsmart.services;

import java.util.List;

import pe.edu.upc.tropsmart.models.entities.DetalleServicio;

public interface DetalleServicioService extends CrudService<DetalleServicio, Integer>{
	List<DetalleServicio> findByTransportistaAndNotEstado(Integer id, String estado) throws Exception;
}
