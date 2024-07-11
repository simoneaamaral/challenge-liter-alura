package br.com.alura.literalurachallenge.repositorio;

import br.com.alura.literalurachallenge.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Livro l JOIN l.autor a WHERE a.autor = :autor")
    Autor buscarAutorPeloNome(String autor);

    @Query("SELECT a FROM Livro b JOIN b.autor a WHERE a.anoNascimento <= :ano and a.anoFalecimento >= :ano")
    List<Autor> procuraAutoresAno(Integer ano);

    @Query("SELECT a FROM Autor a WHERE a.autor ILIKE %:nomeAutor%")
    List<Autor> procuraPorNomeAutor(String nomeAutor);
}
