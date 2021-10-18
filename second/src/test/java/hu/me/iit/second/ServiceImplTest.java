package hu.me.iit.second;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
	
	  @Test
	  void callHelpAndPassParameter5Test() {
		  // GIVEN
		  final int FIVE = 5;

		  // WHEN
		  service.callHelpAndPassParameter5();

		  // THEN
		  ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

		  verify(dependency, times(1)).helpWithParameterNoReturnValue(captor.capture());
		  assertEquals(FIVE,captor.getValue());
	  }
	  
	  @Test
	  void getImportantAbstractTest() {
		  //GIVEN
		  final String expected = "Try...";
		  final String sentence = "Trying the method with this sentence";
		  //WHEN
		  String result = service.getImportantAbstract(sentence);
		  //THEN
		  ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		  verify(dependency, times(1)).Important(captor.capture());
		  assertEquals(expected,captor.getValue());
	  }
}
