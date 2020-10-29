package pe.edu.upc.tropsmart.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tropsmart.models.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	List<Cliente> findByNombresContaining(String nombres) throws Exception;
	List<Cliente> findByApellidosStartingWith(String apellidos) throws Exception;
	Optional<Cliente> findByNumeroDocumento(String numeroDocumento) throws Exception;
	Optional<Cliente> findByNombreUsuario(String nombreUsuario) throws Exception;
	Optional<Cliente> findByNombreUsuarioAndClave(String nombreUsuario, String clave) throws Exception;
}
