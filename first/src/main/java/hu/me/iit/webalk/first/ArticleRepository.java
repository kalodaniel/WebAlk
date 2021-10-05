package hu.me.iit.webalk.first;

import java.util.List;

public interface ArticleRepository {
	List<ArticlesDto> findAll();
	ArticlesDto getById(Long id);
	Long save(ArticlesDto aricleDto);
	void deleteById(Long id);
}
