package hu.me.iit.third;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope("prototype")
public class ServiceImpl implements Service {
	private final Dependency dependency;
	private String value;
	
	
	@Value("${sajat-cucc}")
	public void setValue(String value) {
		this.value = value;
	}

	public ServiceImpl(Dependency dependency) {
		this.dependency=dependency;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void calculate() {
		dependency.helpNoParameterNoReturnValue();
		
	}
}
