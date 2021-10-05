package hu.me.iit.webalk.first;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
//a validalas meg nem helyes
//kiváltja az article-t a pathban mindenhol máshol
@RequestMapping(path="articles")
public class MainController {
	
	private final ArticleService articleService;
	
	public MainController(ArticleService articleService) {
		this.articleService = articleService;
	}

	//A getMapping metódust jelöl, hogy van-e controlleren belül osztály és vannak-e benne metódusok, útvonal megjelölés
	
	@GetMapping(path="", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<ArticlesDto> allArticles(){
	
	}
	
	@GetMapping(path="/{id}", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ArticlesDto articlesById(@PathVariable("id") String id){
		int found = findArticleById(id);
		return articleService.get(found);
	}
	
	@PostMapping(path="")
	public void newArticle(@Valid @RequestBody ArticlesDto articleDto) {
		articleService.save(articleDto);
	}
	
	private int findArticleById(String id) {
		int found = -1;
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(id)) {
				found = i;
				break;
			}
		}
		return found;
	}
	
	@PutMapping(path="/{id}")
	public void replaceArticle(@PathVariable("id") String id, @Valid @RequestBody ArticlesDto articleDto) {
		int found = findArticleById(id);
		
		if(found!=-1) {
			ArticlesDto foundArticle = articles.get(found);
			foundArticle.setAuthor(articleDto.getAuthor());
			foundArticle.setPages(articleDto.getPages());
		}
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteArticle(@PathVariable("id") Long id) {
		articleService.deleteById(id);
	}
	
}
