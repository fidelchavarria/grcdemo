package net.grc.demo.dao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.grc.demo.dao.QuerySearchRepository;
import net.grc.demo.model.QuerySearch;
@Service
@Transactional
public class QuerySearchService {
	
	@Autowired
	private QuerySearchRepository querySearchRepository;
    
	
	public QuerySearch save(QuerySearch qsearch) {
		querySearchRepository.create(qsearch);
		return querySearchRepository.getQuerySearchById(qsearch.getId()); 
	}
	
	public void delete(QuerySearch qsearch) {
		querySearchRepository.delete(qsearch.getId());
	}
	
	
	public QuerySearch findById(long id) {
		return querySearchRepository.getQuerySearchById(id);
	}
	
	
	public List<QuerySearch> findAll() {
		return querySearchRepository.findAllQuerySearch();
	}

	public List<QuerySearch> saveAll(List<QuerySearch> retlist) {
		return querySearchRepository.saveAll(retlist);
	}
	
	
}
