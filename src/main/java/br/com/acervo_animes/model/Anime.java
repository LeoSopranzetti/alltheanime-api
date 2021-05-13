package br.com.acervo_animes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Anime {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Long animacao;
	private Long enredo;
	private Long personagens;
	@Column(length = 1000)
	private String urlImagem;
	@Column(length = 1000)
	private String conclusao;
	private String autor;
	
	private String genero;
	
	
	@ManyToOne @JsonIgnore
	private Usuario usuario;
	
	@OneToMany(mappedBy = "anime", cascade = CascadeType.REMOVE)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy = "anime", cascade = CascadeType.REMOVE)
	private List<AnimeAtributos> animeAtributos;
	
	
	public Anime() {
	}
	
	public Anime(String nome, Long animacao, Long enredo, Long personagens,  String urlImagem, String conclusao, Usuario usuario, String genero) {
		super();
		this.nome = nome;
		this.animacao = animacao;
		this.enredo = enredo;
		this.personagens = personagens;
		this.urlImagem = urlImagem;
		this.conclusao = conclusao;
		this.usuario = usuario;
		this.genero = genero;

	}
	
	
	@Override
	public String toString() {
		return "Anime [id=" + id + ", nome=" + nome + ", animacao=" + animacao + ", enredo=" + enredo + ", personagens="
				+ personagens + ", urlImagem="  + ", conclusao="   + ", usuario=" + usuario.getNome() + "]";
	}

	
	

	

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	
}
