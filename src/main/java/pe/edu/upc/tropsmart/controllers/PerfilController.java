package pe.edu.upc.tropsmart.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.tropsmart.models.entities.Cliente;
import pe.edu.upc.tropsmart.models.entities.Transportista;
import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.models.entities.Usuario;
import pe.edu.upc.tropsmart.security.UsuarioDetails;
import pe.edu.upc.tropsmart.services.ClienteService;
import pe.edu.upc.tropsmart.services.ServicioService;
import pe.edu.upc.tropsmart.services.TransportistaService;
import pe.edu.upc.tropsmart.utils.Segmento;

@Controller
@RequestMapping("/perfil")
@SessionAttributes("{transportista}")
public class PerfilController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TransportistaService transportistaService;
	
	@GetMapping
	public String perfil(@ModelAttribute("transportista") Transportista transportista, Model model) {
		
		// Obtener el usuarioDetails para obtener los datos de cliente o transportista
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails)authentication.getPrincipal();
		
		// Obtener los datos del CLiente o proveedor 
		try {
			if (usuarioDetails.getSegmento() == Segmento.CLIENTE) {
				Optional<Cliente> optional = clienteService.findById(usuarioDetails.getIdSegmento());
				if (optional.isPresent()) {
					model.addAttribute("segmento", "CLIENTE");
					model.addAttribute("cliente", optional.get());
				}
			} 
			else if (usuarioDetails.getSegmento() == Segmento.TRANSPORTISTA) {
				Optional<Transportista> optional = transportistaService.findById(usuarioDetails.getIdSegmento());
				if (optional.isPresent()) {
					model.addAttribute("segmento", "TRANSPORTISTA");
					model.addAttribute("transportista", optional.get());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		model.addAttribute("transportista", transportista);
		return "perfil/perfil";
	}
}

