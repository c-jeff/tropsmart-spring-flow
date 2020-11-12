package pe.edu.upc.tropsmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.tropsmart.models.entities.Servicio;
import pe.edu.upc.tropsmart.services.ServicioService;

@Controller
@RequestMapping("/servicios")
@SessionAttributes("servicio")
public class ServicioController {

	@Autowired
	private ServicioService servicioService;
	
	@GetMapping("{id}")
	private String add(@ModelAttribute("servicio") Servicio servicio, @PathVariable("id") Integer id, Model model){
		try {
		servicioService.save(servicio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
