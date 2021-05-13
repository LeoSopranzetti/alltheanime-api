package br.com.acervo_animes.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acervo_animes.dto.AnimeAtributosDto;
import br.com.acervo_animes.dto.AnimeForm;
import br.com.acervo_animes.model.Anime;
import br.com.acervo_animes.model.AnimeAtributos;
import br.com.acervo_animes.repository.AnimeAtributosRepository;
import br.com.acervo_animes.repository.AnimeRepository;
import br.com.acervo_animes.repository.ComentarioRepository;
import br.com.acervo_animes.repository.UsuarioRepository;


@RestController
@RequestMapping("/animes")
public class AnimeController {
	
	@Autowired
	private AnimeRepository animeRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private AnimeAtributosRepository animeAtributosRepository;
	
	@GetMapping("/listar")
	public List<Anime> listar(){
		List<Anime> animes = animeRepository.findAll();
		for (Anime anime : animes) {
			String user = anime.getUsuario().getNome();
			anime.setAutor(user);
		}
		return animes;
	}
	

	@PostMapping("/listar")
	public List<Anime> listarUser(@RequestBody AnimeForm form){
		List<Anime> animes = animeRepository.findByusuario_id(form.getIdUsuario());
		for (Anime anime : animes) {
			String user = anime.getUsuario().getNome();
			anime.setAutor(user);
		}
		return animes;
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<AnimeForm> salvar(@RequestBody AnimeForm form) {
		Anime anime = form.converter(usuarioRepository);
		animeRepository.save(anime);
		AnimeAtributosDto atributos = new AnimeAtributosDto();
		atributos.setAnimacao(form.getAnimacao());
		atributos.setEnredo(form.getEnredo());
		atributos.setPersonagens(form.getPersonagens());
		AnimeAtributos animeAtributos = atributos.converter(animeRepository, usuarioRepository, anime.getId(), anime.getUsuario().getId());
		animeAtributosRepository.save(animeAtributos);
		return ResponseEntity.ok().body(new AnimeForm(anime));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Anime> optional = animeRepository.findById(id);
		if (optional.isPresent()) {
			animeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	@GetMapping("listar/{id}")
	@Transactional
	public ResponseEntity<Optional> detalhar(@PathVariable Long id) {
		Optional<Anime> optional = animeRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok().body(optional);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("listar/{id}")
	@Transactional
	public ResponseEntity<AnimeForm> atualizar(@PathVariable Long id, @RequestBody AnimeForm form) {
		Optional<Anime> optional = animeRepository.findById(id);
		if (optional.isPresent()) {
			Anime anime = form.atualizar(id, animeRepository);
			return ResponseEntity.ok(new AnimeForm(anime));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
}
