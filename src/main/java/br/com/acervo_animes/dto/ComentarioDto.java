package br.com.acervo_animes.dto;

import br.com.acervo_animes.model.Anime;
import br.com.acervo_animes.model.Comentario;
import br.com.acervo_animes.model.Usuario;
import br.com.acervo_animes.repository.AnimeRepository;
import br.com.acervo_animes.repository.UsuarioRepository;

public class ComentarioDto {
	
	private Long id;
	private String valor;
	private Anime anime;
	private Usuario usuario;

	public ComentarioDto () {
		
	}
	
	public ComentarioDto(Comentario comentario) {
		this.id = comentario.getId();
		this.valor = comentario.getValor();
		this.anime = comentario.getAnime();
		this.usuario = comentario.getUsuario();
	}

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public Anime getAnime() {
		return anime;
	}


	public void setAnime(Anime anime) {
		this.anime = anime;
	}


	public Comentario converter(AnimeRepository animeRepository, UsuarioRepository usuarioRepository, Long idAnime, Long idUsuario) {
		Anime anime = animeRepository.findByid(idAnime);
		Usuario usuario = usuarioRepository.findByid(idUsuario);
		return new Comentario(valor, anime, usuario);
	}

}
