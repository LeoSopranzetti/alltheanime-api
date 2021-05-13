package br.com.acervo_animes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acervo_animes.dto.ComentarioDto;
import br.com.acervo_animes.model.Comentario;
import br.com.acervo_animes.repository.AnimeRepository;
import br.com.acervo_animes.repository.ComentarioRepository;
import br.com.acervo_animes.repository.UsuarioRepository;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private AnimeRepository animeRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping("/{idUsuario}/{idAnime}")
	@Transactional
	public ResponseEntity<ComentarioDto> comentario(@PathVariable(name = "idUsuario") Long idUsuario,@PathVariable(name = "idAnime") Long idAnime, @RequestBody ComentarioDto form) {
		Comentario comentario = form.converter(animeRepository,usuarioRepository, idAnime, idUsuario);
		comentarioRepository.save(comentario);
		return ResponseEntity.ok().body(new ComentarioDto(comentario));
	}
	
	@GetMapping("/{idUsuario}/{idAnime}")
	@Transactional
	public List<Comentario> comentarioListar(@PathVariable(name = "idUsuario") Long idUsuario,@PathVariable(name = "idAnime") Long idAnime) {
		List<Comentario> comentarios = comentarioRepository.findByanime_id(idAnime);
		List<String> nomes = new ArrayList();
		for (Comentario comentario : comentarios) {
			
		comentario.setNome(comentario.getUsuario().getNome());
			
			
			
		}
		return (comentarios);
	}
}
