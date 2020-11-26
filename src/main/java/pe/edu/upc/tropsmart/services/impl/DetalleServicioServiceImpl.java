package pe.edu.upc.tropsmart.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.tropsmart.models.entities.DetalleServicio;
import pe.edu.upc.tropsmart.models.repositories.DetalleServicioRepository;
import pe.edu.upc.tropsmart.services.DetalleServicioService;

@Service
public class DetalleServicioServiceImpl implements DetalleServicioService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DetalleServicioRepository detalleServicioRepository;
	
	@Transactional
	@Override
	public DetalleServicio save(DetalleServicio entity) throws Exception {
		return detalleServicioRepository.save(entity);
	}

	@Transactional
	@Override
	public DetalleServicio update(DetalleServicio entity) throws Exception {
		return detalleServicioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		detalleServicioRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DetalleServicio> findAll() throws Exception {
		return detalleServicioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<DetalleServicio> findById(Integer id) throws Exception {
		return detalleServicioRepository.findById(id);
	}

	@Override
	public List<DetalleServicio> findByTransportistaAndNotEstado(Integer id, String estado) throws Exception {
		return detalleServicioRepository.findByTransportistaAndNotEstado(id, estado); 
	}

}
