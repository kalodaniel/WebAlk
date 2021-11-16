package hu.me.iit.webapps.db.Service;


public class People {
	
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
	
	public People(hu.me.iit.webapps.db.Repository.People people) {
		this.age = people.getAge();
		this.name = people.getName();
		this.id = people.getId();
	}

	public People(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public hu.me.iit.webapps.db.Repository.People toEntity(){
		return new hu.me.iit.webapps.db.Repository.People(id,name,age);
	}
	
	public hu.me.iit.webapps.db.Repository.People toEntityWithoutName(){
		return new hu.me.iit.webapps.db.Repository.People(id,age);
	}
	
}
