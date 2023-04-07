package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		//return "redirect:/app/index";//en vez de reotrnar la vista siemepre comenzando con / ruta absoluta
		//return "redirect:https://www.google.com";
		return "forward:/app/index";//sin reiniciar el request ni recargar pag
	}
}
