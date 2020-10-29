package pe.edu.upc.tropsmart.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tropsmart.models.entities.Transportista;

@Repository
public interface TransportistaRepository extends JpaRepository<Transportista, Integer>{
	List<Transportista> findByNombresContaining(String nombres) throws Exception;
	List<Transportista> findByApellidosStartingWith(String apellidos) throws Exception;
	Optional<Transportista> findByNumeroDocumento(String numeroDocumento) throws Exception;
	Optional<Transportista> findByNombreUsuario(String nombreUsuario) throws Exception;
	Optional<Transportista> findByNombreUsuarioAndClave(String nombreUsuario, String clave) throws Exception;
}
