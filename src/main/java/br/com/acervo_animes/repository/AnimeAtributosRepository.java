package br.com.acervo_animes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acervo_animes.model.AnimeAtributos;

@Repository
public interface AnimeAtributosRepository extends JpaRepository<AnimeAtributos, Long>{

	List<AnimeAtributos> findByanime_id(Long idAnime);

}
