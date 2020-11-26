package pe.edu.upc.tropsmart.controllers;

import java.util.Date;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.tropsmart.models.entities.Cliente;
import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.models.entities.Transportista;
import pe.edu.upc.tropsmart.security.UsuarioDetails;
import pe.edu.upc.tropsmart.services.ClienteService;
import pe.edu.upc.tropsmart.services.ServicioService;
import pe.edu.upc.tropsmart.services.TransportistaService;

@Controller
@RequestMapping("/transportistas")
@SessionAttributes("{transportista, transportistaVenta, servicio}")
public class TransportistaController {

	Servicio servicio;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TransportistaService transportistaService;
	
	@Autowired
	private ServicioService servicioService;

	@PostMapping("addServicio")
	public String save(@ModelAttribute("servicio") Servicio servicio) {
		try {
			if (servicio.getFechaSolicitud() == null)
				servicio.setFechaSolicitud(new Date());
			servicio.setEstado("Pendiente");
			servicioService.save(servicio);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";
	}
	
	@PostMapping("search")
	public String search(@ModelAttribute("transportista") Transportista transportista, Model model) {
		model.addAttribute("transportista", transportista);
		try {
			List<Transportista> transportistas = transportistaService.findByNombres((transportista.getNombres()));
			model.addAttribute("transportistas", transportistas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "transportistas/search-result";
	}
	
	@GetMapping("{id}/p")
	public String view(@ModelAttribute("transportista") Transportista transportista, @PathVariable("id") Integer id, Model model) {
		model.addAttribute("transportista", transportista);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails)authentication.getPrincipal();
		servicio = new Servicio();
		try {
			Optional<Cliente> op = clienteService.findById(usuarioDetails.getIdSegmento());
			servicio.setCliente(op.get());
			servicio.setClienteId(op.get().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("servicio", servicio);
		try {
			Optional<Transportista> optional = transportistaService.findById(id);

			if (optional.isPresent()) {
				model.addAttribute("transportistaVenta", optional.get());
				servicio.setTransportista(optional.get());
				servicio.setTransportistaId(optional.get().getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "transportistas/profile";
	}
}
