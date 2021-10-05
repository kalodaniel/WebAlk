package hu.me.iit.webalk.first;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl implements ArticleService {
	private final int MAXIMUM_ARTICLE_COUNT=10;
	private final ArticleRepository articleRepository;

	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public List<ArticlesDto> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public ArticlesDto getById(Long id) {
		return articleRepository.getById(id);
	}

	@Override
	public Long save(ArticlesDto aricleDto) {
		if(articleRepository.findAll().size() >= MAXIMUM_ARTICLE_COUNT) {
			throw new TooMuchArticleException();
		}
		return articleRepository.save(aricleDto);
	}

	@Override
	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}

}
