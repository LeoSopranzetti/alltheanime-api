package br.com.acervo_animes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acervo_animes.dto.AnimeForm;
import br.com.acervo_animes.model.Anime;
import br.com.acervo_animes.model.Usuario;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long>{


	List<Anime> findByusuario_id(Long idUsuario);
	
	public Anime findByid(Long id);

}
