package pe.edu.upc.tropsmart.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pe.edu.upc.tropsmart.models.entities.DetalleServicio;

@Repository
public interface DetalleServicioRepository extends JpaRepository<DetalleServicio, Integer>{
	
}
