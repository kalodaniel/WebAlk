package hu.me.iit.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;

//Annak tesztelése, hogy ugyan az-e a MainController és a SecondaryController defaultban, igen a válasz
//A default scope singleton
//A @Scope("prototype") anotációval viszont már 2 darab bean lesz 

@SpringBootApplication
public class ThirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdApplication.class, args);
	}

}
