package br.com.acervo_animes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AnimeAtributos {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long animacao;
	private Long enredo;
	private Long personagens;
	private Double mediaGeral;
	
	@ManyToOne @JsonIgnore
	private Usuario usuario;
	
	@ManyToOne @JsonIgnore
	private Anime anime;
	
	public AnimeAtributos() {
		
	}

	public AnimeAtributos(Long animacao, Long enredo, Long personagens, Double mediaGeral, Usuario usuario, Anime anime) {
		super();
		this.animacao = animacao;
		this.enredo = enredo;
		this.personagens = personagens;
		this.mediaGeral = mediaGeral;
		this.usuario = usuario;
		this.anime = anime;
	}

	public Double getMediaGeral() {
		return mediaGeral;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setMediaGeral(Double mediaGeral) {
		this.mediaGeral = mediaGeral;
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


	public Anime getAnime() {
		return anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}
	
	
}
