package br.com.acervo_animes.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.acervo_animes.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
	
	@Value("${acervo_animes.jwt.expiration}")
	private String expiration;
	
	@Value("${acervo_animes.jwt.secret}")
	private String secret;
	
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date date = new Date();
		long t = date.getTime();
	    Date expirationTime = new Date(t + 30000l);
		
		return Jwts.builder()
				.setSubject(logado.getId().toString())
				.signWith(key).compact();
	}
	
	public boolean isTokenValido(String token) {
		try {
			 Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}