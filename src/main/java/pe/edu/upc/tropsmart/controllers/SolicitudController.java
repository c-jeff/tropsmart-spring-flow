package pe.edu.upc.tropsmart.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.models.entities.Transportista;
import pe.edu.upc.tropsmart.security.UsuarioDetails;
import pe.edu.upc.tropsmart.services.ServicioService;

@Controller
@RequestMapping("/solicitudes")
@SessionAttributes("{transportista, detalleServicio}")
public class SolicitudController {
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping("mis")
	public String misSolicitudes(@ModelAttribute("transportista") Transportista transportista, Model model) {
		model.addAttribute("transportista", transportista);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails)authentication.getPrincipal();
		
		try {
			List<Servicio> servicios = servicioService.findByClienteAndEstado(
					usuarioDetails.getIdSegmento(), "Pendiente");
		
			model.addAttribute("servicios", servicios);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "solicitudes/view";
	}
	
	@GetMapping("{id}/d")
	public String verDetalle(@ModelAttribute("transportista") Transportista transportista, Model model, @PathVariable("id") Integer id) {
		model.addAttribute("transportista", transportista);
		
		try {
			Optional<Servicio> optional = servicioService.findById(id);
			model.addAttribute("servicio", optional.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "solicitudes/view-detalles";
	}
	@GetMapping("{id}/c")
	public String confirmarEntrega(@ModelAttribute("transportista") Transportista transportista, Model model, @PathVariable("id") Integer id) {
		model.addAttribute("transportista", transportista);
		
		try {
			Optional<Servicio> optional = servicioService.findById(id);
			
			optional.get().setEstado("Entregado");
			servicioService.save(optional.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/solicitudes/mis";
	}
	
	@GetMapping("{id}/edp")
	public String delDetallePedido(@ModelAttribute("transportista") Transportista transportista, Model model, @PathVariable("id") Integer id) {
		model.addAttribute("transportista", transportista);
		
		try {
			Optional<Servicio> optional = servicioService.findById(id);
			if (optional.isPresent()) {
				servicioService.deleteById(id);
				return "redirect:/solicitudes/mis";// + optional.get().getId() + "/d";
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/solicitudes/mis";
	}

}