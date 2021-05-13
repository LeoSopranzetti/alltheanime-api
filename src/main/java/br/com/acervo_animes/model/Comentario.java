package br.com.acervo_animes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 1000)
	private String valor;
	
	@ManyToOne @JsonIgnore
	private Anime anime;
	
	@ManyToOne @JsonIgnore
	private Usuario usuario;
	
	@Transient
	private String nome;
	
	public Comentario() {	
	}
	
	public Comentario(String valor, Anime anime, Usuario usuario) {
		this.usuario = usuario;
		this.valor = valor;
		this.anime = anime;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	
}
