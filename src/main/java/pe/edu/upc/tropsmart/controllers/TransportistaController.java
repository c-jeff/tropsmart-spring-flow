package pe.edu.upc.tropsmart.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.models.entities.Transportista;
import pe.edu.upc.tropsmart.services.ServicioService;
import pe.edu.upc.tropsmart.services.TransportistaService;

@Controller
@RequestMapping("/transportistas")
@SessionAttributes("{transportista, transportistaVenta, servicio}")
public class TransportistaController {

	@Autowired
	private TransportistaService transportistaService;
	
	@Autowired
	private ServicioService servicioService;

	@PostMapping("addServicio")
	public String save(@ModelAttribute("servicio") Servicio servicio, @ModelAttribute("transportistaVenta") Transportista transportistaVenta) {
		try {
			servicio.setTransportista(transportistaVenta);
			servicio.setTransportistaId(transportistaVenta.getId());
			servicio.setEstado("pendiente");
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
		try {
			Optional<Transportista> optional = transportistaService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("transportistaVenta", optional.get());
				
				Servicio servicio = new Servicio();
				servicio.setTransportista(optional.get());
				servicio.setTransportistaId(optional.get().getId());
				servicio.setEstado("pendiente");
				
				model.addAttribute("servicio", servicio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "transportistas/profile";
	}
}
