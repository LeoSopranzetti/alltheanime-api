package br.com.acervo_animes.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Usuario implements UserDetails {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String senha;
	private String nome;
	private String cidade;
	
	@OneToMany(mappedBy = "usuario")
	private List<AnimeAtributos> animesAtributos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Anime> animes;
	
	@OneToMany(mappedBy = "usuario")
	private List<Comentario> comentarios;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
	public Usuario() {
	}
	
	public Usuario(Long id, String email, String senha) {
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(Long id, String email, String senha, String nome, String cidade, List<Anime> animes) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.animes = animes;
	}
	
	public Usuario(Long id, String email, String senha, String nome, String cidade) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
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
	
	public void setPassword(String password) {
		this.senha = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	
	
	
	public List<Anime> getAnimes() {
		return animes;
	}

	public void setAnimes(List<Anime> animes) {
		this.animes = animes;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return this.senha;
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
	
	
	
}
