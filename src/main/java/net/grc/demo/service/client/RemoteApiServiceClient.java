package net.grc.demo.service.client;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.grc.demo.model.Post;
import net.grc.demo.model.User;

@Service
public class RemoteApiServiceClient {

	public List<Post> findPostContainingString(String[] query) {

		List<Post> retlist = new LinkedList<Post>();
		
		ResponseEntity<Post[]> postEntities = restTemplate().getForEntity("https://jsonplaceholder.typicode.com/posts",
				Post[].class);
		Post[] post = postEntities.getBody();

		for (Post p : post) {
			for (String q :query) {
				if (p.getTitle().contains(q)) 
					retlist.add(p);
			}
		}

		return retlist;

	}

	
	public Post findPostById(int postId) {
		Post post = restTemplate().getForObject("https://jsonplaceholder.typicode.com/posts/" + postId, Post.class);
		post.setUser(findUserById(post.getUserId()));
		return post;
	}
	
	public User findUserById(int id) {
		return restTemplate().getForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


	
}
