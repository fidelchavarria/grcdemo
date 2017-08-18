package net.grc.demo.service.client;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.grc.demo.model.Post;
import net.grc.demo.model.QuerySearch;
import net.grc.demo.model.User;

@Service
public class RemoteApiServiceClient {

	private TreeMap<Date, QuerySearch> sorter = new TreeMap<Date, QuerySearch>();
	private final AtomicLong counter = new AtomicLong();

	public List<QuerySearch> findPostContainingString(String[] query) {

		ResponseEntity<Post[]> postEntities = restTemplate().getForEntity("https://jsonplaceholder.typicode.com/posts",
				Post[].class);
		Post[] post = postEntities.getBody();

		for (Post p : post) {
			for (String q :query) {
				
				if (p.getTitle().contains(q)) {
					p.setUser(findUserById(p.getUserId()));
					Date now = new Date();
					sorter.put(now, new QuerySearch(counter.incrementAndGet(), q, p));
				}
			}
			
		}

		// TODO save to DB and retorn list From DataBase

		sorter.lastEntry();
		return new LinkedList<QuerySearch>(sorter.values());

	}


	public User findUserById(int id) {
		return restTemplate().getForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
