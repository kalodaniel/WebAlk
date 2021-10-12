package hu.me.iit.second;

public class ServiceImpl implements Service {
	private final Dependency dependency;
	
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

	@Override
	public int helpNoParameterReturnValue() {
		// TODO Auto-generated method stub
		return 0;
	}	
}
