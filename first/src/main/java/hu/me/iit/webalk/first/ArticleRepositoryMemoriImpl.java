package hu.me.iit.webalk.first;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryMemoriImpl implements ArticleRepository {
	private final List<ArticlesDto> articles = new ArrayList<>();
	
	private int findArticleById(Long id) {
		int found = -1;
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(id)) {
				found = i;
				break;
			}
		}
		return found;
	}
	
	@Override
	public List<ArticlesDto> findAll() {
		return articles;
	}

	@Override
	public ArticlesDto getById(Long id) {
		return null;
	}

	@Override
	public Long save(ArticlesDto articleDto) {
		int found = findArticleById(articleDto.getId());
		
		if(found!=-1) {
			ArticlesDto foundArticle = articles.get(found);
			foundArticle.setAuthor(articleDto.getAuthor());
			foundArticle.setPages(articleDto.getPages());
		}else {
			articles.add(articleDto);
		}
	}

	@Override
	public void deleteById(Long id) {
		int found = findArticleById(id);
		
		if(found!=-1) {
			articles.remove(found);
		}
	}
	
	

}
