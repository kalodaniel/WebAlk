package hu.me.iit.Computer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import hu.me.iit.Computer.Exceptions.NoSuchEntityException;
import hu.me.iit.Computer.Exceptions.NoSuchManufacturerException;
import hu.me.iit.Computer.Repository.Computer;
import hu.me.iit.Computer.Repository.ComputerRepository;

@Service
public class ComputerServiceImpl implements ComputerService {

	private ComputerRepository computerRepository;
	
	public ComputerServiceImpl(ComputerRepository computerRepository) {
		this.computerRepository = computerRepository;
	}

	@Override
	public Iterable<ComputerServiceModel> findAll() {
		List<ComputerServiceModel> computerList = new ArrayList<>();
		for (Computer computer : computerRepository.findAll()) {
			computerList.add(new ComputerServiceModel(computer));
		}
		return computerList;
	}

	@Override
	public void create(ComputerServiceModel computerServiceModel) {
		computerRepository.save(computerServiceModel.toEntity());
	}

	@Override
	public void update(ComputerServiceModel computerServiceModel) {
		Optional<Computer> optionalComputer = computerRepository.findById(computerServiceModel.getId());
		if(optionalComputer.isEmpty())
			throw new NoSuchEntityException();
		computerRepository.save(computerServiceModel.toEntity());
		
	}

	@Override
	public void deleteById(@Valid Long id) {
		Optional<Computer> optionalComputer = computerRepository.findById(id);
		if(optionalComputer.isEmpty())
			throw new NoSuchEntityException();
		computerRepository.deleteById(id);
		
	}

	@Override
	public void patch(ComputerServiceModel computerServiceModel) {
		Optional<Computer> optionalComputer = computerRepository.findById(computerServiceModel.getId());
		if(optionalComputer.isEmpty())
			throw new NoSuchEntityException();
		else if(computerServiceModel.getManufacturer()==null && computerServiceModel.getAge()==null) {
			
		}
		else if(computerServiceModel.getManufacturer()==null) {
			optionalComputer.get().setAge(computerServiceModel.getAge());
			computerRepository.save(optionalComputer.get());
		}
		else if(computerServiceModel.getAge()==null) {
			optionalComputer.get().setManufacturer(computerServiceModel.getManufacturer());
			computerRepository.save(optionalComputer.get());
		}
		else {
			computerRepository.save(computerServiceModel.toEntity());
		}
	}

	@Override
	public ComputerServiceModel findById(@Valid Long id) {
		Optional<Computer> optionalComputer = computerRepository.findById(id);
		if(optionalComputer.isEmpty())
			throw new NoSuchEntityException();
		return new ComputerServiceModel(computerRepository.findById(id).get());
	}

	@Override
	public Iterable<ComputerServiceModel> getByAgeGT(Integer age) {
		List<ComputerServiceModel> computerList = new ArrayList<>();
		for (Computer computer : computerRepository.findAllByAgeGreaterThanEqual(age)) {
			computerList.add(new ComputerServiceModel(computer));
		}
		return computerList;
	}

	@Override
	public Iterable<ComputerServiceModel> getByManufact(String manufacturer) {
		List<ComputerServiceModel> computerList = new ArrayList<>();
		for (Computer computer : computerRepository.findAllByManufacturerLike(manufacturer)) {
			computerList.add(new ComputerServiceModel(computer));
		}
		return computerList;
	}

	@Override
	public ComputerServiceModel getOldestComputer() {
		return new ComputerServiceModel(computerRepository.findTopByOrderByAgeDesc());
	}

	@Override
	public ComputerServiceModel getYoungestComputer() {
		return new ComputerServiceModel(computerRepository.findTopByOrderByAgeAsc());
	}

	@Override
	public ComputerServiceModel getOldestComputerByManufacturer(String manufacturer) {
		try {
			return new ComputerServiceModel(computerRepository.findTopByManufacturerLikeOrderByAgeDesc(manufacturer));
		} catch (NullPointerException e) {
			throw new NoSuchManufacturerException();
		}
	}
}
