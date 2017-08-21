package net.grc.demo.service.client;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.grc.demo.model.QuerySearch;

@Service
public class LocalApiServiceClient {
	
	
	public List<QuerySearch> findByQuery(String[] query){
		String  newQuery = prepareQuery(query);
		ResponseEntity<QuerySearch[]> queryEntities = restTemplate().getForEntity("http://localhost:8080/local/search?query="+newQuery,
				QuerySearch[].class);
		QuerySearch[] retval = queryEntities.getBody();
		
		return sortCollection(retval);
		
	}
	
	private String prepareQuery(String[] strings) {
		
		if (strings.length >= 1) {
			String retval = "";
			for (String s : strings) {
				retval += s + ",";
			}
			return retval.substring(0, (retval.length() - 1));
		}
		return "";
	}
	
	
	private List<QuerySearch> sortCollection(QuerySearch[] retval) {
		TreeMap<Date, QuerySearch> sorter = new TreeMap<Date, QuerySearch>();
		for (QuerySearch s : retval)
			sorter.put(s.getDateTime(), s);
		
		if (!sorter.isEmpty())
			sorter.firstKey();
		return new LinkedList<QuerySearch>(sorter.values());
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public void deleteById(Long id) {
		restTemplate().delete("http://localhost:8080/local/delete/"+id);
	}

	public List<QuerySearch> findLocalHistory() {
		ResponseEntity<QuerySearch[]> queryEntities = restTemplate().getForEntity("http://localhost:8080/local/queries",
				QuerySearch[].class);
		QuerySearch[] retval = queryEntities.getBody();
		
		return sortCollection(retval);
	}
}
