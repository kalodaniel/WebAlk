package hu.me.iit.webalk.first;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ArticleMemoryRepositoryTest {

	@Test
	public void findAll_Empty() {
		//Given
		ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
		
		//WHEN
		List<ArticleDto> result = articleMemoryRepository.findAll();
				
		//THEN
		assertEquals(0, result.size());
	}
	
	@Test
	public void findAll_NotEmpty() {
		//Given
		ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("Author");
		articleDto.setPages(23);
		articleDto.setId(2l);
		articleDto.setTitle("title");
		articleMemoryRepository.save(articleDto);
		
		//WHEN
		List<ArticleDto> result = articleMemoryRepository.findAll();
		
		//THEN
		assertEquals(articleDto, result.get(0));
	}
	
	@Test
	public void findById() {
		//Given
				ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
				Long id = 2L;
				ArticleDto articleDto = new ArticleDto();
				articleDto.setAuthor("Author");
				articleDto.setPages(23);
				articleDto.setId(id);
				articleDto.setTitle("title");
				articleMemoryRepository.save(articleDto);
				
				//WHEN
				int result = articleMemoryRepository.findArticleById(id);
				
				//THEN
				assertEquals(0, result);
	}
	
	@Test
	public void findById_NotFound() {
		//Given
				ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
				Long id = 2L;
				Long notExistingId=4L;
				ArticleDto articleDto = new ArticleDto();
				articleDto.setAuthor("Author");
				articleDto.setPages(23);
				articleDto.setId(id);
				articleDto.setTitle("title");
				articleMemoryRepository.save(articleDto);
				
				//WHEN
				int result = articleMemoryRepository.findArticleById(notExistingId);
				
				//THEN
				assertEquals(-1, result);
	}
	
	@Test
	public void deleteById_exists() {
		//Given
				ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
				Long id = 2L;
				Long notExistingId=4L;
				ArticleDto articleDto = new ArticleDto();
				articleDto.setAuthor("Author");
				articleDto.setPages(23);
				articleDto.setId(id);
				articleDto.setTitle("title");
				articleMemoryRepository.save(articleDto);
				
				//WHEN
				articleMemoryRepository.deleteById(id);
				
				//THEN
				assertEquals(0, articleMemoryRepository.findAll().size());
	}
	
	@Test
	public void deleteById_NotExists() {
		//Given
				ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
				Long id = 2L;
				Long notExistingId=4L;
				ArticleDto articleDto = new ArticleDto();
				articleDto.setAuthor("Author");
				articleDto.setPages(23);
				articleDto.setId(id);
				articleDto.setTitle("title");
				articleMemoryRepository.save(articleDto);
				
				//WHEN
				articleMemoryRepository.deleteById(notExistingId);
				
				//THEN
				assertEquals(1, articleMemoryRepository.findAll().size());
	}
	
	@Test
	public void getById_notExists() {
		//Given
				ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
				Long id = 2L;
				Long notExistingId=4L;
				ArticleDto articleDto = new ArticleDto();
				articleDto.setAuthor("Author");
				articleDto.setPages(23);
				articleDto.setId(id);
				articleDto.setTitle("title");
				articleMemoryRepository.save(articleDto);
				
				//WHEN
				ArticleDto dto = articleMemoryRepository.getById(notExistingId);
				
				//THEN
				assertNull(dto);
	}
	
	@Test
	public void getById_Exists() {
		//Given
		ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
		Long id = 2L;
		Long notExistingId=4L;
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("Author");
		articleDto.setPages(23);
		articleDto.setId(id);
		articleDto.setTitle("title");
		articleMemoryRepository.save(articleDto);
				
		//WHEN
		ArticleDto dto = articleMemoryRepository.getById(id);
				
		//THEN
		assertEquals(articleDto, dto);
	}
	
	@Test
	public void save_Update() {
		//Given
		ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
		Long id = 2L;
		Long notExistingId=4L;
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("Author");
		articleDto.setPages(23);
		articleDto.setId(id);
		articleDto.setTitle("title");
		articleMemoryRepository.save(articleDto);
						
		//WHEN
		ArticleDto articleDto2 = new ArticleDto();
		articleDto2.setAuthor("Author2");
		articleDto2.setPages(14);
		articleDto2.setId(id);
		articleDto2.setTitle("title2");
		articleMemoryRepository.save(articleDto2);
						
		//THEN
		List<ArticleDto> articleDtoList = articleMemoryRepository.findAll();
		assertEquals(1,articleDtoList.size());
		assertEquals(articleDto, articleMemoryRepository.getById(id));
	}
	
	
	
}
