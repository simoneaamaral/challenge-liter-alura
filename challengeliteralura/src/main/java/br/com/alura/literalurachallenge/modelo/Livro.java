package br.com.alura.literalurachallenge.modelo;

import br.com.alura.literalurachallenge.dto.LivroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
    private String idioma;
    private Double totalDownloads;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    private Autor autor;



    public Livro() {
    }

    public Livro(LivroDTO livroDTO) {
        this.id = livroDTO.id();
        this.titulo = livroDTO.titulo();
        this.idioma = livroDTO.idioma().get(0);
        this.totalDownloads = livroDTO.numeroDownload();
        this.autor = new Autor(livroDTO.authors().get(0));
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getTotalDownloads() {
        return totalDownloads;
    }
    public void setTotalDownloads(Double totalDownloads) {
        this.totalDownloads = totalDownloads;
    }

    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }



    @Override
    public String toString() {
        return
                "\nid: " + id + '\n' +
                "titulo: '" + titulo + '\'' + '\n' +
                "idioma: " + idioma + '\n' +
                "totalDownloads: " + totalDownloads + '\n' +
                "autor[ " + autor + "]\n";
    }
}
