package hu.me.iit.third;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
	
	@Bean
	@Scope("prototype")
	public Service myService(Dependency dep) {
		return new ServiceImpl(dep);
	}
}