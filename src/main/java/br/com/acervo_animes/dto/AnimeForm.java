package br.com.acervo_animes.dto;

import br.com.acervo_animes.model.Anime;
import br.com.acervo_animes.model.Usuario;
import br.com.acervo_animes.repository.AnimeRepository;
import br.com.acervo_animes.repository.UsuarioRepository;

public class AnimeForm {
	
	private Long id;
	private Long animacao;
	private Long enredo;
	private Long personagens;
	private String nome;
	private String urlImagem;
	private String conclusao;
	private Long idUsuario;
	private String genero;
	
	private Usuario usuario;
	
	public AnimeForm(Anime anime) {
		this.id = anime.getId();
		this.nome = anime.getNome();
		this.animacao = anime.getAnimacao();
		this.enredo = anime.getEnredo();
		this.personagens = anime.getPersonagens();
		this.urlImagem = anime.getUrlImagem();
		this.conclusao = anime.getConclusao();
		this.usuario = anime.getUsuario();
		this.genero = anime.getGenero();
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

	public AnimeForm() {
		
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
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

	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Anime converter(UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findByid(idUsuario);		
		return new Anime(nome, animacao, enredo, personagens, urlImagem, conclusao, usuario, genero);
		
	}



	public Anime atualizar(Long id2, AnimeRepository animeRepository) {
		Anime anime= animeRepository.getOne(id2);
		
		anime.setNome(this.nome);
		anime.setAnimacao(this.animacao);
		anime.setEnredo(this.enredo);
		anime.setPersonagens(this.personagens);
		anime.setUrlImagem(this.urlImagem);
		anime.setConclusao(this.conclusao);
		anime.setGenero(this.genero);
		
		return anime;
	}
	
	
}
