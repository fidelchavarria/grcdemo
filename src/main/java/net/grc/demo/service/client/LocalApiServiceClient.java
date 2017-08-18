package net.grc.demo.service.client;

import java.util.Arrays;
import java.util.List;

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
		return Arrays.asList(retval);
		
	}
	
	private String prepareQuery(String[] strings) {
		String retval = "";
		for (String s : strings) {
			retval += s + ",";
		}
		return retval.substring(0, (retval.length() - 1));
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
