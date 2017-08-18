package net.grc.demo.model;

import java.util.Date;
import java.util.UUID;

public class QuerySearch {

	private int id;
	private long uuid;
	private String query;
	private Post post;
	private Date dateTime;
	
	public QuerySearch (long uuid, String query, Post post) {
		this.uuid = uuid;
		this.query = query;
		this.post = post;
		dateTime = new Date();
	}
	
	public QuerySearch () {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	@Override
	public String toString() {
		return "QuerySearch [uuid=" + uuid + ", query=" + query + ", post=" + post + ", dateTime=" + dateTime + "]";
	}
	public long getUuid() {
		return uuid;
	}
	public void setUuid(long uuid) {
		this.uuid = uuid;
	}
	
	
}
