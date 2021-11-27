package hu.me.iit.Computer.Service;

import hu.me.iit.Computer.Repository.Computer;

public class ComputerServiceModel {
	private Long id;
	private String manufacturer;
	private Integer age;
	
	public ComputerServiceModel(Long id, String manufacturer, Integer age) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.age = age;
	}
	
	public ComputerServiceModel() {
		
	}

	public ComputerServiceModel(Computer computer) {
		this.id = computer.getId();
		this.manufacturer = computer.getManufacturer();
		this.age = computer.getAge();
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

	public void setAge(int age) {
		this.age = age;
	}

	public Computer toEntity() {
		return new Computer(id,manufacturer, age);
	}
	
	
	
	
}
