package com.bjv.bjvbackend.articles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	List<ArticleWithoutContent> findAllProjectedBy();

}
