package net.grc.demo.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.grc.demo.dao.service.QuerySearchService;
import net.grc.demo.model.Post;
import net.grc.demo.model.QuerySearch;
import net.grc.demo.service.client.RemoteApiServiceClient;

@RestController
public class HistoricQuerySearchController {

	private static final Logger log = LoggerFactory.getLogger(HistoricQuerySearchController.class);
	private final static AtomicLong counter = new AtomicLong();
	
	@Autowired
	private RemoteApiServiceClient remoteApiService;
	
	@Autowired
	private QuerySearchService queryService;

	@RequestMapping(value = "/local/search")
	public List<QuerySearch> search(@RequestParam(value = "query", defaultValue = "") String[] query) {
		List<Post> retlist = remoteApiService.findPostContainingString(query);
		log.info("Found {} result on remote service", retlist.size());
		buildAndSave(retlist, query);
		return findAll();
	}
	
	@RequestMapping(value = "/local/delete/{id}", method = RequestMethod.DELETE )
	public void delete(@PathVariable("id")  long id) {
		log.info("Deleting id {} from database", id);
		QuerySearch q = queryService.findById(id);
		if (q != null)
			queryService.delete(q);
	}
	
	@RequestMapping(value = "/local/queries", method = RequestMethod.GET )
	public List<QuerySearch> findAll() {
		
		List<QuerySearch> retlist = new ArrayList<QuerySearch>();
		List<QuerySearch> history = queryService.findAll();
		 
		 for (QuerySearch q : history) {
			 Post post = remoteApiService.findPostById(q.getPostId());
			 q.setPost(post);
			 retlist.add(q);
		 }
		 
		 return retlist;
	}
	
	
	private void buildAndSave(List<Post> post, String[] query) {
		for (Post p : post) {
			for (String q :query) {
				queryService.save(new QuerySearch(counter.incrementAndGet(), q, p));
			}
		}
	}
	
}
