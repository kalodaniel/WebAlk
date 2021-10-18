package hu.me.iit.second;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DependencyImpl implements Dependency {

	@Override
	public void helpNoParameterNoReturnValue() {
	}

	@Override
	public int helpNoParameterReturnValue() {
		return 45;
	}
	
	@Override
	public void helpWithParameterNoReturnValue(int a) {
		
	}
	
	@Override
	public String Important(String text) {
		final String before = "<b>";
		final String after = "</b>";
		return new StringBuilder().append(before).append(text).append(after).toString();
				
	}
}
