package pe.edu.upc.tropsmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.tropsmart.models.entities.DetalleServicio;
import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.models.entities.Transportista;
import pe.edu.upc.tropsmart.security.UsuarioDetails;
import pe.edu.upc.tropsmart.services.DetalleServicioService;

@Controller
@RequestMapping("/entregas")
@SessionAttributes("{transportista, detalleServicio}")
public class EntregaController {
	
	@Autowired
	private DetalleServicioService detalleServicioService;
	
	@GetMapping("mis")
	public String misEntregas(@ModelAttribute("transportista") Transportista transportista, Model model) {
		model.addAttribute("transportista", transportista);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails)authentication.getPrincipal();
		
		try {
			List<DetalleServicio> detalles = detalleServicioService
					.findByTransportistaAndNotEstado(usuarioDetails.getIdSegmento(), "Entregado");
		
			model.addAttribute("detalles", detalles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "entregas/view";
	}
}
