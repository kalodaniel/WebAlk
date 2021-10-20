package hu.me.iit.randomProverb;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	private final Service service;
	
	public MainController(Service service) {
		this.service = service;
	}

	@GetMapping(path="/proverb")
	public String getProverb() {
		return service.getProverb();
	}
	
	@GetMapping(path="/student")
	public String getStudent() {
		return service.getStudent();
	}
}
