package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
@Interceptors({LogInterceptador.class})
public class LivroDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void salva(Livro livro) {
		entityManager.persist(livro);
	}

	public List<Livro> todosLivros() {
		return entityManager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	public List<Livro> livrosPeloTitulo(String nome) {
		TypedQuery<Livro> query = this.entityManager
				.createQuery("select l from Livro l where l.titulo like:pNome",
						Livro.class);
		query.setParameter("pNome", "%" + nome + "%");
		return query.getResultList();
	}

}
