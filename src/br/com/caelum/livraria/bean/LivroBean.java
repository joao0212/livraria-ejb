package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.service.AutorService;
import br.com.caelum.livraria.service.LivroService;

@Model
public class LivroBean {

	@Inject
	private LivroService livroService;

	@Inject
	private AutorService autorService;


	private Livro livro = new Livro();
	private Integer autorId;


	public Livro getLivro() {
		return livro;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public List<Livro> getLivros() {
		return this.livroService.todosOsLivros();
	}

	public void cadastra() {
		Autor autor = this.autorService.listarPorId(this.autorId);
		this.livro.setAutor(autor);
		this.livroService.adicionar(livro);
		this.livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorService.todosOsAutores();
	}
}
