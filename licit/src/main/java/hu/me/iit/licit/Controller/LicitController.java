package hu.me.iit.licit.Controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.licit.Service.LicitService;

@RestController
public class LicitController {
	
	private LicitService licitService;
	
	public LicitController(LicitService licitService) {
		this.licitService = licitService;
	}

	@GetMapping("/licit/highest")
	public Integer findHighest(){
		return licitService.findHighest();
	}
	
	@GetMapping("/licit/highestByUser/{userId}")
	public Integer findHighestByUser(@PathVariable Integer userId) {
		return licitService.findHighestByUser(userId);
	}
	
	@PostMapping
	public void saveLicit(@RequestBody @Valid LicitDto licitDto) {
		licitService.save(licitDto.toLicit());
	}
}
