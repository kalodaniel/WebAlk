package hu.me.iit.webapps.db.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class People {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
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

	public People() {
	}

	public People(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public People(Long id, int age) {
		this.id=id;
		this.age=age;
	}
	
}
