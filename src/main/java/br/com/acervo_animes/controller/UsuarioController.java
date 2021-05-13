package br.com.acervo_animes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acervo_animes.dto.UsuarioCad;
import br.com.acervo_animes.model.Usuario;
import br.com.acervo_animes.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping("/cadastro")
	public ResponseEntity<UsuarioCad> cadastrar(@RequestBody @Valid UsuarioCad form){
		Usuario usuario = form.converter2();
		usuarioRepository.save(usuario);
		return ResponseEntity.ok().body(new UsuarioCad(usuario));
	}

}
