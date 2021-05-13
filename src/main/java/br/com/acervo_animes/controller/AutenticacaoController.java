package br.com.acervo_animes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acervo_animes.dto.TokenDto;
import br.com.acervo_animes.dto.UsuarioForm;
import br.com.acervo_animes.model.Usuario;
import br.com.acervo_animes.repository.UsuarioRepository;
import br.com.acervo_animes.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid UsuarioForm usuarioForm){
		UsernamePasswordAuthenticationToken dadosLogin = usuarioForm.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			Usuario usuario = usuarioRepository.findBysenha(usuarioForm.getSenha());
			Long idUsuario = usuario.getId();
			
			return ResponseEntity.ok(new TokenDto(token, "Bearer", idUsuario));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
