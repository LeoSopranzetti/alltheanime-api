package br.com.acervo_animes.dto;

import br.com.acervo_animes.model.Anime;
import br.com.acervo_animes.model.AnimeAtributos;
import br.com.acervo_animes.model.Usuario;
import br.com.acervo_animes.repository.AnimeRepository;
import br.com.acervo_animes.repository.UsuarioRepository;

public class AnimeAtributosDto {

	private Long id;
	private Long animacao;
	private Long enredo;
	private Long personagens;
	private Double mediaGeral;
	
	private Usuario usuario;
	
	private Anime anime;

	public AnimeAtributosDto() {
		
	}
	
	public AnimeAtributosDto(AnimeAtributos anime) {
		this.id = anime.getId();
		this.animacao = anime.getAnimacao();
		this.enredo = anime.getEnredo();
		this.personagens = anime.getPersonagens();
		this.usuario = anime.getUsuario();
		this.anime = anime.getAnime();
		this.mediaGeral = anime.getMediaGeral();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnimacao() {
		return animacao;
	}

	public void setAnimacao(Long animacao) {
		this.animacao = animacao;
	}

	public Long getEnredo() {
		return enredo;
	}

	public void setEnredo(Long enredo) {
		this.enredo = enredo;
	}

	public Long getPersonagens() {
		return personagens;
	}

	public void setPersonagens(Long personagens) {
		this.personagens = personagens;
	}

	public Double getMediaGeral() {
		return mediaGeral;
	}

	public void setMediaGeral(Double mediaGeral) {
		this.mediaGeral = mediaGeral;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Anime getAnime() {
		return anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	public AnimeAtributos converter(AnimeRepository animeRepository, UsuarioRepository usuarioRepository, Long idAnime,
			Long idUsuario) {
		Anime anime = animeRepository.findByid(idAnime);
		Usuario usuario = usuarioRepository.findByid(idUsuario);	
		mediaGeral = (double) ((animacao + enredo + personagens) / 3);
		return new AnimeAtributos(animacao, enredo, personagens, mediaGeral, usuario, anime);
	}
	
	
}
