package hu.uni.me.iit.SpringConsoleApp;

import java.util.Arrays;

public class Car {
	private final Engine engine;
	private final Wheels[] wheels;
	private final String type;
	
	public Car(Engine engine, Wheels[] wheels, String type) {
		this.engine = engine;
		this.wheels = wheels;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [engine=" + engine.toString() + ", wheels=" + wheels[0].toString() + ", type=" + type + "]";
	}
	
	
}
