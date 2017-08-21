package net.grc.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_querySearch")
public class QuerySearch implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -1932018271611769916L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	private Long uuid;
	private String query;
	@Transient
	private Post post;
	private Integer postId;
	private Date dateTime;
	
	public QuerySearch (long uuid, String query, Post post) {
		this.uuid = uuid;
		this.query = query;
		this.post = post;
		this.postId = post.getId();
		dateTime = new Date();
	}
	
	public QuerySearch () {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	
	
}
