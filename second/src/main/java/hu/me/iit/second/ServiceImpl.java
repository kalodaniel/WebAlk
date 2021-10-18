package hu.me.iit.second;

import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {
	private final Dependency dependency;
	private final String dotCharacters = "...";
	final int MAX_CHARACTER_NUMBER = 3;
	
	public ServiceImpl(Dependency dependency) {
		this.dependency=dependency;
	}
	
	@Override
	public void calculate() {
		dependency.helpNoParameterNoReturnValue();
	}
	
	public int returnWithFive() {
		return 5;
	}
	
	@Override
	public int callHelpAndUseReturnValue() {
		return dependency.helpNoParameterReturnValue();
	}

	public void callHelpAndPassParameter5() {
		dependency.helpWithParameterNoReturnValue(5);
	}

	@Override
	public int helpNoParameterReturnValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getImportantAbstract(String input) {
		String firstThreeChars, charsWithDots;
		if(input.length()>MAX_CHARACTER_NUMBER) {
			firstThreeChars = input.substring(0, MAX_CHARACTER_NUMBER);
		}
		else {
			firstThreeChars = input;
		}
		charsWithDots = firstThreeChars.concat(dotCharacters);
		return dependency.Important(charsWithDots);
	}
}
