package net.rj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.rj.model.Categoria;
import net.rj.service.ICategoriasService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@Autowired
	ICategoriasService serviceCategorias;
	
	// @RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
		return "categorias/listCategorias";
	}
	
	// @RequestMapping(value="/create", method=RequestMethod.GET)
	@GetMapping("/create")
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	// @RequestMapping(value="/save", method=RequestMethod.POST)
	@PostMapping("/save")
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			
			return "vacantes/formVacante";
		}
		
		serviceCategorias.guardar(categoria);
		System.out.println("Categoria: " + categoria);
		
		//Flash Attribute
		attributes.addFlashAttribute("msg", "Registro Guardado");
		
		return "redirect:/categorias/index";
	}
}
