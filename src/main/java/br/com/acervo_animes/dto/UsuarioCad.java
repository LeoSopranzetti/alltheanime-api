package br.com.acervo_animes.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.acervo_animes.model.Usuario;

public class UsuarioCad {
	private Long id;
	@Email(message="Email inválido!") @NotEmpty(message="Não pode estar vázio!")
	private String email;
	@NotEmpty(message="Não pode estar vázio!")
	private String senha;
	@NotEmpty(message="Não pode estar vázio!")
	private String nome;
	@NotEmpty(message="Não pode estar vázio!")
	private String cidade;
	
	public UsuarioCad(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.nome = usuario.getNome();
		this.cidade = usuario.getCidade();
	}

	public UsuarioCad() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Usuario converter2() {
		return new Usuario(id, email, senha, nome, cidade);
	}


	
}

