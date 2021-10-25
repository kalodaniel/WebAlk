package cars;

import impl.InsideBurnEngine;

public class Main {
	public static void main(String[] args) {
		Engine engine16 = new InsideBurnEngine(180,1600);
		
		Car opelAstra = new Car(engine16,get4Wheels(),"Opel Astra");
		
		System.out.println(opelAstra);
	}
	
	
	private static Wheels[] get4Wheels(){
		Wheels[] wheels = new Wheels[4];
		
		for (int i = 0; i < wheels.length; i++) {
			wheels[i] = new impl.Wheels(205,16,65);
		}
		return wheels;
	}
}
