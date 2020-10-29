package pe.edu.upc.tropsmart.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.tropsmart.models.entities.Transportista;
import pe.edu.upc.tropsmart.models.repositories.TransportistaRepository;
import pe.edu.upc.tropsmart.services.TransportistaService;

@Service
public class TransportistaServiceImpl implements TransportistaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TransportistaRepository transportistaRepository;
	
	@Transactional
	@Override
	public Transportista save(Transportista entity) throws Exception {
		return transportistaRepository.save(entity);
	}

	@Transactional
	@Override
	public Transportista update(Transportista entity) throws Exception {
		return transportistaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		transportistaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Transportista> findAll() throws Exception {
		return transportistaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Transportista> findById(Integer id) throws Exception {
		return transportistaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Transportista> findByNombres(String nombres) throws Exception {
		return transportistaRepository.findByNombresContaining(nombres);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Transportista> findByApellidos(String apellidos) throws Exception {
		return transportistaRepository.findByApellidosStartingWith(apellidos);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Transportista> findByNumeroDocumento(String numeroDocumento) throws Exception {
		return transportistaRepository.findByNumeroDocumento(numeroDocumento);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Transportista> findByNombreUsuarioAndClave(String nombreUsuario, String clave) throws Exception {
		return transportistaRepository.findByNombreUsuarioAndClave(nombreUsuario, clave);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Transportista> findByNombreUsuario(String nombreUsuario) throws Exception {
		return transportistaRepository.findByNombreUsuario(nombreUsuario);
	}

}
