package hu.me.iit.randomProverb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class ServiceImpl implements Service {
	private final ProverbRepository repository;
	
	public ServiceImpl(ProverbRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public String getProverb() {
		return repository.getProverb();
	}

	@Override
	public String getStudent() {
		return repository.getStudent();
	}

}
