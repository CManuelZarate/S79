package com.bolsadeideas.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")//indicamos donde se encuentra en el app.proper
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	//retorna el nombre de la vista a cargar
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping( {"/index","/","/home"})
	public String index(Model model) {
	//public ModelAndView index(ModelAndView mv) {
		//llave ty valor
		//mv.addObject("titulo", "hola string fw");
		//mv.setViewName("index");
		//return mv;
		model.addAttribute("titulo",textoIndex);
		return "index";//plantilla en templates
	}
	
	@RequestMapping("/perfil")
	public String perfil( Model model ) {
		//esto vendria de una consulta a la BD usando Hibernate JPA a traves de una clase repository,service
		Usuario usuario = new Usuario();
		usuario.setNombre("Andres");
		usuario.setApellido("Apellido");
		usuario.setEmail("camazala@gmail.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",textoPerfil.concat( usuario.getNombre() ));
		return "perfil";
	}
	
	
	@RequestMapping("/listar")
	public String listar( Model model ) {
		//List<Usuario> usuarios = new ArrayList<>();
		

		
		model.addAttribute("titulo",textoListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")//pasamos el nombre con el q queremos guardar en la vista
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios =Arrays.asList(new Usuario("Andres","Gonzales","andres@gmail.com"),new Usuario("Pedro","Gonzales","pepe@gmail.com"),new Usuario("Abimael","Gonzales","andres@gmail.com") );
		return usuarios;
	}
	
}
