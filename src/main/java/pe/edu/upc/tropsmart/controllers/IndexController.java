package pe.edu.upc.tropsmart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.models.entities.Transportista;

@Controller
@RequestMapping("/")
@SessionAttributes("{transportista, servicio}")
public class IndexController {
	
	@GetMapping
	public String index(Model model) throws Exception {
		Transportista transportista = new Transportista();
		Servicio servicio = new Servicio();
		model.addAttribute("transportista", transportista);
		model.addAttribute("servicio", servicio);
		return "index";
	}
	
	@GetMapping("template")
	public String template() {
		return "template";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
