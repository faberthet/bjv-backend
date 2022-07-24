package com.bjv.bjvbackend.articles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable long id) {
		Article article = articleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("article not exist with id" + id));
		return ResponseEntity.ok(article);
	}
	
	@PutMapping("articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody Article EditedArticle ) {
		
		Article article = articleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("article not exist with id" + id));
		
		article.setTitre(EditedArticle.getTitre());
		article.setTheme(EditedArticle.getTheme());
		article.setContent(EditedArticle.getContent());
		
		Article UpdatedArticle = articleRepository.save(article);
		
		return ResponseEntity.ok(UpdatedArticle);
		
	}
	
	@DeleteMapping("articles/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteArticle(@PathVariable long id) {
		Article article = articleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("article not exist with id" + id));
		
		articleRepository.delete(article);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
