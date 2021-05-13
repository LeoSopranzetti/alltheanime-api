package br.com.acervo_animes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CadastroController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/homeUser")
	public String homeuser() {
		return "homeUser";
	}
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "animeForm";
	}

	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	
}
