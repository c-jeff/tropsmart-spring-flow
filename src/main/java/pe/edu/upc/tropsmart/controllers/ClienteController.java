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

import pe.edu.upc.tropsmart.models.entities.Cliente;
import pe.edu.upc.tropsmart.models.entities.Distrito;
import pe.edu.upc.tropsmart.services.ClienteService;
import pe.edu.upc.tropsmart.services.DistritoService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private DistritoService distritoService;
	
	@GetMapping
	public String inicio(Model model) {
		Cliente cliente = new Cliente();
		
		try {
			List<Cliente> clientes = clienteService.findAll();
			List<Distrito> distritos = distritoService.findAll();
			model.addAttribute("clientes", clientes);
			model.addAttribute("cliente", cliente);
			model.addAttribute("distritos", distritos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "clientes/index";
	}

	@PostMapping("save")
	public String save(@ModelAttribute("cliente") Cliente cliente) {
		try {
			clienteService.save(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/clientes";
	}
	
	@GetMapping("/{id}/p")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("cliente", optional.get());
				return "clientes/view";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/clientes";
	}
	
	@GetMapping("search")
	public String search() {
		return "clientes/search";
	}
}
