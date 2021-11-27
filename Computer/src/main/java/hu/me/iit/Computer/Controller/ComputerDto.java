package hu.me.iit.Computer.Controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import hu.me.iit.Computer.Service.ComputerServiceModel;

public class ComputerDto {
	private Long id;
	@NotEmpty
	private String manufacturer;
	@Min(0)
	private Integer age;
	
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
	
	public ComputerDto(Long id, @NotEmpty String manufacturer, @NotEmpty @Min(0) Integer age) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.age = age;
	}
	
	public ComputerDto() {
		
	}
	
	public ComputerDto(ComputerServiceModel computerServiceModel) {
		this.id = computerServiceModel.getId();
		this.manufacturer = computerServiceModel.getManufacturer();
		this.age = computerServiceModel.getAge();
	}
	
	public ComputerServiceModel toComputerServiceModel() {
		return new ComputerServiceModel(id, manufacturer, age);
	}
	
	
	
	
	
}
