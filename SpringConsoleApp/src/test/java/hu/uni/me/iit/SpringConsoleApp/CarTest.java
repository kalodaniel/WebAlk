package hu.uni.me.iit.SpringConsoleApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import hu.uni.me.iit.SpringConsoleApp.impl.ElectricEngine;
import hu.uni.me.iit.SpringConsoleApp.impl.InsideBurnEngine;

@ExtendWith(MockitoExtension.class)
class CarTest {

	@Mock Wheels wheels;
	@Mock Engine engine;
	@InjectMocks Car car;
	
	@Test
	void toStringInsideBurnEngineTest() {
		//GIVEN
		final String expected = "Engine [horsePow=160, ccm=120]";
		final int horsePow = 160;
		final int ccm = 120;
		Engine engine = new InsideBurnEngine(horsePow,ccm);
		//WHEN
		final String result = engine.toString();
		//THEN
		assertEquals(expected,result);
	}
	
	@Test
	void toStringElectricEngineTest() {
		//GIVEN
		final String expected = "ElectricEngine [performance=160, tension=120]";
		final int performance = 160;
		final int tension = 120;
		Engine engine = new ElectricEngine(performance,tension);
		//WHEN
		final String result = engine.toString();
		//THEN
		assertEquals(expected,result);
	}
	
	@Test
	void toStringWheelsTest() {
		//GIVEN
		final String expected = "[width=15/20 R 17]";
		final int width = 15;
		final int diameter = 17;
		final int cloackHeight = 20;
		hu.uni.me.iit.SpringConsoleApp.Wheels wheels = new hu.uni.me.iit.SpringConsoleApp.impl.Wheels(width,diameter,cloackHeight);
		//WHEN
		final String result = wheels.toString();
		//THEN
		assertEquals(expected, result);
	}
		
	@Test
	void isEngingeCalledTest() {
		//GIVEN
		final String expected = "Car [engine=Engine [horsePow=160, ccm=120], wheels=[width=205/65 R 16], type=Ford]";
		final String wheelsReturn = "[width=205/265 R 16]";
		final String engineReturn = "Engine [horsePow=160, ccm=120]";
		final String type = "Ford";
		//when(wheels.toString()).thenReturn(wheelsReturn);
		when(engine.toString()).thenReturn(engineReturn);
		Car car = new Car(engine,get4Wheels(),type);
		//WHEN
		String result = car.toString();
		//THEN
		assertEquals(expected, result);
	}
	
	private static Wheels[] get4Wheels(){
		Wheels[] wheels = new Wheels[4];
		
		for (int i = 0; i < wheels.length; i++) {
			wheels[i] = new hu.uni.me.iit.SpringConsoleApp.impl.Wheels(205,16,65);
		}
		return wheels;
	}
	
	@Test
	void isWheelsCalled() {
		
	}

}
