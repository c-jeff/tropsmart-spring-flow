package pe.edu.upc.tropsmart.init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.tropsmart.models.entities.Usuario;
import pe.edu.upc.tropsmart.models.repositories.UsuarioRepository;
import pe.edu.upc.tropsmart.utils.Segmento;

@Service
public class AddUserDB implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// SOLO DESBLOQUEAR CUANDO SE REQUIERA CREAR USUARIO DE FORMA MANUAL
		
		/*BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
		Usuario cliente1 = new Usuario();
		cliente1.setUsername("cliente1");
		cliente1.setPassword( bcpe.encode("cliente") );
		cliente1.setEnable(true);
		cliente1.setSegmento(Segmento.CLIENTE);
		cliente1.setIdSegmento(1);
		
		Usuario cliente2 = new Usuario();
		cliente2.setUsername("cliente2");
		cliente2.setPassword( bcpe.encode("cliente") );
		cliente2.setEnable(true);
		cliente2.setSegmento(Segmento.CLIENTE);
		cliente2.setIdSegmento(2);
		
		Usuario cliente3 = new Usuario();
		cliente3.setUsername("cliente3");
		cliente3.setPassword( bcpe.encode("cliente") );
		cliente3.setEnable(true);
		cliente3.setSegmento(Segmento.CLIENTE);
		cliente3.setIdSegmento(3);
		
		Usuario cliente4 = new Usuario();
		cliente4.setUsername("cliente4");
		cliente4.setPassword( bcpe.encode("cliente") );
		cliente4.setEnable(true);
		cliente4.setSegmento(Segmento.CLIENTE);
		cliente4.setIdSegmento(4);
		
		Usuario transportista1 = new Usuario();
		transportista1.setUsername("transportista1");
		transportista1.setPassword( bcpe.encode("transportista") );
		transportista1.setEnable(true);
		transportista1.setSegmento(Segmento.TRANSPORTISTA);
		transportista1.setIdSegmento(1);
		
		Usuario transportista2 = new Usuario();
		transportista2.setUsername("transportista2");
		transportista2.setPassword( bcpe.encode("transportista") );
		transportista2.setEnable(true);
		transportista2.setSegmento(Segmento.TRANSPORTISTA);
		transportista2.setIdSegmento(2);
		
		Usuario transportista3 = new Usuario();
		transportista3.setUsername("transportista3");
		transportista3.setPassword( bcpe.encode("transportista") );
		transportista3.setEnable(true);
		transportista3.setSegmento(Segmento.TRANSPORTISTA);
		transportista3.setIdSegmento(3);
		
		Usuario transportista4 = new Usuario();
		transportista4.setUsername("transportista4");
		transportista4.setPassword( bcpe.encode("transportista") );
		transportista4.setEnable(true);
		transportista4.setSegmento(Segmento.TRANSPORTISTA);
		transportista4.setIdSegmento(4);
		
		// ROLE_CUSTOMER, ROLE_PROVIDER, ROLE_ADMIN
		cliente1.addAuthority("ROLE_CUSTOMER");
		cliente2.addAuthority("ROLE_CUSTOMER");
		cliente3.addAuthority("ROLE_CUSTOMER");
		cliente4.addAuthority("ROLE_CUSTOMER");
		
		transportista1.addAuthority("ROLE_DRIVER");
		transportista2.addAuthority("ROLE_DRIVER");
		transportista3.addAuthority("ROLE_DRIVER");
		transportista4.addAuthority("ROLE_DRIVER");
		
		// ACCESS_
		cliente1.addAuthority("ACCESS_DESC");
		cliente2.addAuthority("ACCESS_PROMO");
		
		usuarioRepository.save(cliente1);
		usuarioRepository.save(cliente2);
		usuarioRepository.save(cliente3);
		usuarioRepository.save(cliente4);
		
		usuarioRepository.save(transportista1);
		usuarioRepository.save(transportista2);
		usuarioRepository.save(transportista3);
		usuarioRepository.save(transportista4);*/
		
	}

}