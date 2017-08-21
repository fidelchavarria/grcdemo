package net.grc.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import net.grc.demo.model.QuerySearch;

@Repository
public class QuerySearchRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(QuerySearch querySearch) {
		entityManager.persist(querySearch);
	}

	public void update(QuerySearch querySearch) {
		entityManager.merge(querySearch);
	}

	public QuerySearch getQuerySearchById(long id) {
		return entityManager.find(QuerySearch.class, id);
	}

	public List<QuerySearch> findAllQuerySearch() {
		return entityManager.createQuery("select e from QuerySearch e ",
				QuerySearch.class).getResultList();
	}
	
	public void delete(long id) {
		QuerySearch querySearch = getQuerySearchById(id);
		if (querySearch != null) {
			entityManager.remove(querySearch);
		}
	}

	public List<QuerySearch> saveAll(List<QuerySearch> retlist) {
		
		for (QuerySearch s : retlist)
			entityManager.merge(s);
		
		return  findAllQuerySearch();
	}
}
