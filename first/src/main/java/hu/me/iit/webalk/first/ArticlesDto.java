package hu.me.iit.webalk.first;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArticlesDto {
	
	@NotNull
	private Long id;
	
	@NotBlank
	@NotNull
	private String author;
	@NotBlank
	private String title;
	@Min(10)
	private Integer pages;
	
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ArticlesDto [id=" + id + ", author=" + author + ", title=" + title + ", pages=" + pages
				+ ", getAuthor()=" + getAuthor() + ", getTitle()=" + getTitle() + ", getPages()=" + getPages()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
