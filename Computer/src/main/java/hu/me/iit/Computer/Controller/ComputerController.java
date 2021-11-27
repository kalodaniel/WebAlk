package hu.me.iit.Computer.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.Computer.Service.ComputerService;
import hu.me.iit.Computer.Service.ComputerServiceModel;
@RestController
@RequestMapping("/computers")
public class ComputerController {
	
	private ComputerService computerService;

	public ComputerController(ComputerService computerService) {
		this.computerService = computerService;
	}

	@GetMapping("/getAllComputers")
	public Iterable<ComputerDto> findAll(){
		List<ComputerDto> computerDtoList = new ArrayList<>();
		for (ComputerServiceModel computerServiceModel : computerService.findAll()) {
			computerDtoList.add(new ComputerDto(computerServiceModel));
		}
		return computerDtoList;
	}
	
	@PostMapping("/createNewComputer")
	public void createNewComputer(@RequestBody @Valid ComputerCreateDto computerCreateDto) {
		computerService.create(computerCreateDto.toComputerServiceModel());
	}
	
	@PutMapping("/updateComputer")
	public void update(@RequestBody @Valid ComputerDto computerDto) {
		computerService.update(computerDto.toComputerServiceModel());
	}
	
	@DeleteMapping("/deleteComputer/{id}")
	public void delete(@PathVariable @Valid Long id) {
		computerService.deleteById(id);
	}
	
	@PatchMapping("/patchComputer")
	public void patch(@RequestBody ComputerDto computerDto) {
		computerService.patch(computerDto.toComputerServiceModel());
	}
	
	@GetMapping("/getById/{id}")
	public ComputerDto findById(@PathVariable @Valid Long id) {
		return new ComputerDto(computerService.findById(id));
	}
	
	@GetMapping("/getComputersByAgeGT")
	public Iterable<ComputerDto> getByAgeGT(@RequestParam Integer age){
		List<ComputerDto> computerDtoList = new ArrayList<>();
		for (ComputerServiceModel computer : computerService.getByAgeGT(age)) {
			computerDtoList.add(new ComputerDto(computer));
		}
		return computerDtoList;
	}
	
	@GetMapping("/getComputerByManufact")
	public Iterable<ComputerDto> getByManufact(@RequestParam String manufacturer){
		List<ComputerDto> computerDtoList = new ArrayList<>();
		for (ComputerServiceModel computer : computerService.getByManufact(manufacturer)) {
			computerDtoList.add(new ComputerDto(computer));
		}
		return computerDtoList;
	}
	
	@GetMapping("/getOldestComputer")
	public ComputerDto getOldestComputer() {
		return  new ComputerDto(computerService.getOldestComputer());
	}
	
	@GetMapping("/getYoungestComputer")
	public ComputerDto getYoungestComputer() {
		return new ComputerDto(computerService.getYoungestComputer());
	}
	
	@GetMapping("/getOldestByManufacturer")
	public ComputerDto getOldestByManufacturer(@RequestParam String manufacturer) {
		return new ComputerDto(computerService.getOldestComputerByManufacturer(manufacturer));
	}
}
