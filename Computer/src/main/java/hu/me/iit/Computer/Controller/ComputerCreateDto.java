package hu.me.iit.Computer.Controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import hu.me.iit.Computer.Service.ComputerServiceModel;

public class ComputerCreateDto {
	@NotEmpty
	private String manufacturer;
	@Min(0)
	private Integer age;
	
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
	
	public ComputerCreateDto(Long id, @NotEmpty String manufacturer, @NotEmpty @Min(0) Integer age) {
		this.manufacturer = manufacturer;
		this.age = age;
	}
	
	public ComputerCreateDto() {
		
	}
	
	public ComputerCreateDto(ComputerServiceModel computerServiceModel) {
		this.manufacturer = computerServiceModel.getManufacturer();
		this.age = computerServiceModel.getAge();
	}
	
	public ComputerServiceModel toComputerServiceModel() {
		return new ComputerServiceModel(null, manufacturer, age);
	}
	
	
	
	
}
