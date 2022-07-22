package com.bjv.bjvbackend.articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjv.bjvbackend.contact.ContactModel;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("articles")
	public List<Article> getAllArticles(){
		
		return articleRepository.findAll();
	}
	
	@PostMapping("articles")
	public Article sendEmail(@RequestBody Article article){
		
		return articleRepository.save(article);
	}

	
}
