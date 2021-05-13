package br.com.acervo_animes.repository;

import java.util.Optional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acervo_animes.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmail(String email);

	public Usuario findBysenha(String senha);

	public Usuario findByid(Long idUsuario);

	
	

	
	

}
