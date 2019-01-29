package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	private AutorDao autorDao;

	public void adicionar(Autor autor) {
		this.autorDao.salva(autor);
	}

	public List<Autor> todosOsAutores(){
		return this.autorDao.todosAutores();
	}

	public Autor listarPorId(Integer id) {
		return this.autorDao.buscaPelaId(id);
	}
}


