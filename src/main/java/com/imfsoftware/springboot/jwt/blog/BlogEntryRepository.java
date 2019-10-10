package com.imfsoftware.springboot.jwt.blog;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogEntryRepository extends MongoRepository<BlogEntry,String> {
	public List<BlogEntry> findByTitle(String title);
}
