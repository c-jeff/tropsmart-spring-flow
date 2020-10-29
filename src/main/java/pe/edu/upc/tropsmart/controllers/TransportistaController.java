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

import pe.edu.upc.tropsmart.models.entities.Distrito;
import pe.edu.upc.tropsmart.models.entities.Transportista;
import pe.edu.upc.tropsmart.services.DistritoService;
import pe.edu.upc.tropsmart.services.TransportistaService;

@Controller
@RequestMapping("/transportistas")
public class TransportistaController {

	@Autowired
	private TransportistaService transportistaService;
	
	@Autowired
	private DistritoService distritoService;
	
	@GetMapping
	public String inicio(Model model) {
		Transportista transportista = new Transportista();
		
		try {
			List<Transportista> transportistas = transportistaService.findAll();
			List<Distrito> distritos = distritoService.findAll();
			model.addAttribute("transportistas", transportistas);
			model.addAttribute("transportista", transportista);
			model.addAttribute("distritos", distritos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "transportistas/index";
	}

	@PostMapping("save")
	public String save(@ModelAttribute("transportista") Transportista transportista) {
		try {
			transportistaService.save(transportista);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/transportistas";
	}
	
	@GetMapping("/{id}/p")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Transportista> optional = transportistaService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("transportista", optional.get());
				return "transportistas/view";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/transportistas";
	}
	
	@GetMapping("search")
	public String search() {
		return "transportistas/search";
	}
}
