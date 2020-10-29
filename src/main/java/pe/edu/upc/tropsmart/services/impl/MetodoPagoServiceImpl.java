package pe.edu.upc.tropsmart.services.impl;

import java.io.Serializable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.tropsmart.models.entities.MetodoPago;
import pe.edu.upc.tropsmart.models.repositories.MetodoPagoRepository;
import pe.edu.upc.tropsmart.services.MetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MetodoPagoRepository metodoPagoRepository;
	
	@Transactional
	@Override
	public MetodoPago save(MetodoPago entity) throws Exception {
		return metodoPagoRepository.save(entity);
	}

	@Transactional
	@Override
	public MetodoPago update(MetodoPago entity) throws Exception {
		return metodoPagoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		metodoPagoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<MetodoPago> findAll() throws Exception {
		return metodoPagoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<MetodoPago> findById(Integer id) throws Exception {
		return metodoPagoRepository.findById(id);
	}

}
