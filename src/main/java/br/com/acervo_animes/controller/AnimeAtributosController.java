package br.com.acervo_animes.controller;

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

import br.com.acervo_animes.dto.AnimeAtributosDto;
import br.com.acervo_animes.model.AnimeAtributos;
import br.com.acervo_animes.repository.AnimeAtributosRepository;
import br.com.acervo_animes.repository.AnimeRepository;
import br.com.acervo_animes.repository.UsuarioRepository;

@RestController
@RequestMapping("/atributos")
public class AnimeAtributosController {

	@Autowired
	private AnimeRepository animeRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AnimeAtributosRepository atributosRepository;
	
	
	@PostMapping("/{idUsuario}/{idAnime}")
	public ResponseEntity<AnimeAtributosDto> salvar(@PathVariable(name = "idUsuario") Long idUsuario,@PathVariable(name = "idAnime") Long idAnime, @RequestBody AnimeAtributosDto form){
		AnimeAtributos anime = form.converter(animeRepository,usuarioRepository, idAnime, idUsuario);
		atributosRepository.save(anime);
		return ResponseEntity.ok().body(new AnimeAtributosDto(anime));
	}
	
	@GetMapping("/{idAnime}")
	@Transactional
	public Double media(@PathVariable(name = "idAnime") Long idAnime) {
		List<AnimeAtributos> animes = atributosRepository.findByanime_id(idAnime);
		Double mediaGeral = 0.0;
		Integer i1 = 1;
		Integer i2 = 2;
		for (AnimeAtributos animeAtributos : animes) {
			if(i1 == 1 ) {
			mediaGeral = (mediaGeral + animeAtributos.getMediaGeral()) / i1;
			i1 = 2;
			} else {
			mediaGeral = (mediaGeral + animeAtributos.getMediaGeral()) / i2;
			}
		}
		return mediaGeral;
	}
}
