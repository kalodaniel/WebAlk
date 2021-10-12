package hu.me.iit.second;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

	@Mock Dependency dependency;
	
	@InjectMocks ServiceImpl service;
	
	@Test
	void calculateTest() {
		//GIVEN
		
		//WHEN
		service.calculate();
		
		//THEN
		verify(dependency, times(1)).helpNoParameterNoReturnValue();
	}
	
	@Test
	void returnWithFiveTest() {
		//GIVEN
		final int FIVE=5;
		
		//WHEN
		int result = service.returnWithFive();
		
		//THEN
		assertEquals(FIVE, result);
	}
	
	@Test
	void dependencyReturnValueIsUsed() {
		//GIVEN
		final int FIVE=5;
		when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);
		//WHEN
		int result = service.callHelpAndUseReturnValue();
		//THEN
		verify(dependency,times(1)).helpNoParameterReturnValue();
		assertEquals(FIVE, result);
	}
}
