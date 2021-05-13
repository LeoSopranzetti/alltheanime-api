package br.com.acervo_animes.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.acervo_animes.model.Usuario;

public class UsuarioForm {

	private Long id;
	@Email(message="Email inválido!") @NotEmpty(message="Não pode estar vázio!")
	private String email;
	@NotEmpty(message="Não pode estar vázio!")
	private String senha;
	
	public UsuarioForm(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	public UsuarioForm() {
		
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

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken (email, senha);
	}

	public Usuario converter2() {
		return new Usuario(id, email, senha);
	}


	
}


