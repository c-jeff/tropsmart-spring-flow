package pe.edu.upc.tropsmart.controllers;

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
import pe.edu.upc.tropsmart.models.entities.DetalleServicio;
import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.models.entities.Transportista;
import pe.edu.upc.tropsmart.security.UsuarioDetails;
import pe.edu.upc.tropsmart.services.ClienteService;
import pe.edu.upc.tropsmart.services.ServicioService;

@Controller
@RequestMapping("/servicios")
@SessionAttributes("{transporista, servicio, detalle}")
public class ServicioController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServicioService servicioService;
	
	@PostMapping("adddetail")
	public String addDetail(@ModelAttribute("detalle") DetalleServicio detalle, Model model) {
		//System.out.println(detallePedido.getProducto().getDescripcion());
		System.out.println(detalle.getDescripcion());
		//System.out.println(detallePedido.getProveedor().getNombre());
		return "redirect:/";
	}
	
	@GetMapping("mis")
	public String misServicios(@ModelAttribute("transportista") Transportista transportista, Model model) {
		model.addAttribute("transportista", transportista);
		// Obtener el cliente
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails)authentication.getPrincipal();
		
		try {
			Optional<Cliente> optional = clienteService.findById(usuarioDetails.getIdSegmento());
			model.addAttribute("cliente", optional.get());
			System.out.println(optional.get().getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "servicios/view";
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
		return "servicios/view-detalles";
	}
}