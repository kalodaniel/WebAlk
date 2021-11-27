package hu.me.iit.Computer;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import hu.me.iit.Computer.Exceptions.NoSuchEntityException;
import hu.me.iit.Computer.Repository.Computer;
import hu.me.iit.Computer.Repository.ComputerRepository;
import hu.me.iit.Computer.Service.ComputerServiceImpl;
import hu.me.iit.Computer.Service.ComputerServiceModel;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

	@Mock ComputerRepository computerRepository;
	@InjectMocks ComputerServiceImpl serviceImpl;

	@Test
	public void findAllTest() {
		//Given
		int counter=0;
		//When
		Iterable<ComputerServiceModel> result = serviceImpl.findAll();
		//Then
		verify(computerRepository, times(1)).findAll();
	}
	
	@Test
	public void createTest() {
		//Given
		Computer model = new Computer(2L,"Asus",3);
		//When
		serviceImpl.create(new ComputerServiceModel(model));
		//Then
		ArgumentCaptor<Computer> captor = ArgumentCaptor.forClass(Computer.class);
		verify(computerRepository, times(1)).save(captor.capture());
		assertEquals(model.getId(), captor.getValue().getId());
	}
	
	@Test
	public void updateTest() {
		//Given
		Computer model = new Computer(1L,"Asus",3);
		Optional<Computer> optionalComputer = Optional.of(model);
		when(computerRepository.findById(model.getId())).thenReturn(optionalComputer);
		//When
		serviceImpl.update(new ComputerServiceModel(model));
		//Then
		ArgumentCaptor<Computer> captor = ArgumentCaptor.forClass(Computer.class);
		verify(computerRepository, times(1)).save(captor.capture());
	}
	
	@Test
	public void deleteByIdTest() {
		//Given
		Computer model = new Computer(1L,"Asus",3);
		Optional<Computer> optionalComputer = Optional.of(model);
		when(computerRepository.findById(model.getId())).thenReturn(optionalComputer);
		//When
		serviceImpl.deleteById(model.getId());
		//Then
		verify(computerRepository, times(1)).deleteById(model.getId());
	}
	
	@Test
	public void findByIdTest() {
		//Given
		Computer model = new Computer(1L,"Asus",3);
		Optional<Computer> optionalComputer = Optional.of(model);
		when(computerRepository.findById(model.getId())).thenReturn(optionalComputer);
		//When
		ComputerServiceModel result = serviceImpl.findById(model.getId());
		//Then
		assertEquals("Asus", result.getManufacturer());
	}
	
	

}
