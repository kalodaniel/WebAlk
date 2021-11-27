package hu.me.iit.Computer.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Computer {
	@GeneratedValue
	@Id
	private Long id;
	private String manufacturer;
	private Integer age;
	public Computer(Long id, String manufacturer, Integer age) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.age = age;
	}
	
	public Computer() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	
}
