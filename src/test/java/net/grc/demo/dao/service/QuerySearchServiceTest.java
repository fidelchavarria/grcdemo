package net.grc.demo.dao.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.grc.demo.model.Post;
import net.grc.demo.model.QuerySearch;


@RunWith(SpringRunner.class)
@DataJpaTest
public class QuerySearchServiceTest {

	
	@Autowired
	private QuerySearchService service;
	
	
	public void assertNotNull() {
		Assert.assertNotNull(service);
	}
	
	@Test
	public void crdActions() {
		
		service.saveAll(Arrays.asList(new QuerySearch[]{
		
		new QuerySearch(3453L, "test", new Post(1, "Title for post [1]")),
		new QuerySearch(4536L, "test", new Post(2, "Title for post [1]")),
		new QuerySearch(2676L, "test", new Post(3, "Title for post [1]"))
		
		}));
		
		
		List<QuerySearch> retlist = service.findAll();
		
		Assert.assertEquals(3, retlist.size());
		
		for (QuerySearch q : retlist) {
			 Assert.assertNotNull(q.getId());
			 Assert.assertNotNull(q.getPostId());
		}
		
		QuerySearch query = retlist.get(0);
		service.delete(query);
		
		Assert.assertNull(service.findById(query.getId()));
	}
}
