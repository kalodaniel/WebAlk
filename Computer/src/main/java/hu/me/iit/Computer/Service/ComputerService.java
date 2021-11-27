package hu.me.iit.Computer.Service;

import javax.validation.Valid;

public interface ComputerService {

	Iterable<ComputerServiceModel> findAll();

	void create(ComputerServiceModel computerServiceModel);

	void update(ComputerServiceModel computerServiceModel);

	void deleteById(@Valid Long id);

	void patch(ComputerServiceModel computerServiceModel);

	ComputerServiceModel findById(@Valid Long id);

	Iterable<ComputerServiceModel> getByAgeGT(Integer age);

	Iterable<ComputerServiceModel> getByManufact(String manufacturer);

	ComputerServiceModel getOldestComputer();

	ComputerServiceModel getYoungestComputer();

	ComputerServiceModel getOldestComputerByManufacturer(String manufacturer);

}
