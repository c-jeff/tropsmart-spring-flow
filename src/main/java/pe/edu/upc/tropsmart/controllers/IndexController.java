package pe.edu.upc.tropsmart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.tropsmart.models.entities.Transportista;

@Controller
@RequestMapping("/")
@SessionAttributes("transportista")
public class IndexController {
	
	@GetMapping
	public String index(Model model) throws Exception {
		Transportista transportista = new Transportista();
		model.addAttribute("transportista", transportista);
		return "index";
	}
	
	@GetMapping("template")
	public String template() {
		return "template";
	}
}
