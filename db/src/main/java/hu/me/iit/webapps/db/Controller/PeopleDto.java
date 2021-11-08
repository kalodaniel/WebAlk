package hu.me.iit.webapps.db.Controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import hu.me.iit.webapps.db.Service.People;
//A feladata, hogy ne engedjen be nem megengedett kéréseket
public class PeopleDto {
	
	public PeopleDto() {
	}
	
	public PeopleDto(People people) {
		this.id = people.getId();
		this.age = people.getAge();
		this.name = people.getName();
	}
	private Long id;
	@NotEmpty
	private String name;
	@Size(min=18)
	private int age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
