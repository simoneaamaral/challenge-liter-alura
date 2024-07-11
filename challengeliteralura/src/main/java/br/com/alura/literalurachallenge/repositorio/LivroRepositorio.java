package br.com.alura.literalurachallenge.repositorio;

import br.com.alura.literalurachallenge.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE l.idioma ILIKE :idiomaEscolha")
    List<Livro> findByIdioma(String idiomaEscolha);
}
