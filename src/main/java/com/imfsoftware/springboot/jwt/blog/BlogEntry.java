package com.imfsoftware.springboot.jwt.blog;

import org.springframework.data.annotation.Id;

public class BlogEntry {
	@Id
	private String id;
	private String title;
	private String post;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	@Override
	public String toString() {
		return "BlogEntry [id=" + id + ", title=" + title + ", post=" + post + "]";
	}
}
