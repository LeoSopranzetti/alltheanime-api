package br.com.acervo_animes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acervo_animes.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{



	List<Comentario> findByanime_id(Long idAnime);

}
