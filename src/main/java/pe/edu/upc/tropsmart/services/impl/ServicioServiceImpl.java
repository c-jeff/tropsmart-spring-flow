package pe.edu.upc.tropsmart.services.impl;

import java.io.Serializable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.models.repositories.ServicioRepository;
import pe.edu.upc.tropsmart.services.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ServicioRepository servicioRepository;
	
	@Transactional
	@Override
	public Servicio save(Servicio entity) throws Exception {
		return servicioRepository.save(entity);
	}

	@Transactional
	@Override
	public Servicio update(Servicio entity) throws Exception {
		return servicioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		servicioRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Servicio> findAll() throws Exception {
		return servicioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Servicio> findById(Integer id) throws Exception {
		return servicioRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Servicio> findByEstado(String estado) throws Exception {
		return servicioRepository.findByEstado(estado);
	}

}
