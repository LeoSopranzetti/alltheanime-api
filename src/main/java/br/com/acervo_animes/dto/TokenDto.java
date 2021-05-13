package br.com.acervo_animes.dto;

public class TokenDto {

	private Long idUsuario;
	private String token;
	private String tipo;

	public TokenDto(String token, String tipo, Long idUsuario) {
		this.idUsuario = idUsuario;
		this.token = token;
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}







	
	
	

}
