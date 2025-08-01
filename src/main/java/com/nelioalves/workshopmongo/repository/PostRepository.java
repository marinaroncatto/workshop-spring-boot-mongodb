package com.nelioalves.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//consulta personalizada utilizando linguagem do mongoDB
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	//busca no campo title do doc o primeiro parâmentro (?0) ingnorando case ('i')
	
	
	//query method
	List<Post> findByTitleContainingIgnoreCase(String text);
}
