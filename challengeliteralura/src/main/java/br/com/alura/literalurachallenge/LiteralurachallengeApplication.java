package br.com.alura.literalurachallenge;

import br.com.alura.literalurachallenge.principal.Principal;
import br.com.alura.literalurachallenge.repositorio.AutorRepositorio;
import br.com.alura.literalurachallenge.repositorio.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteralurachallengeApplication implements CommandLineRunner {

	@Autowired
	LivroRepositorio livroRepositorio;

	@Autowired
	AutorRepositorio autorRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(LiteralurachallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroRepositorio, autorRepositorio);
		principal.exibeMenu();
	}
}
