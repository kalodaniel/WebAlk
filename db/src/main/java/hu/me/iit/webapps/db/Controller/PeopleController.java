package hu.me.iit.webapps.db.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.webapps.db.Service.People;
import hu.me.iit.webapps.db.Service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {
	private final PeopleService peopleService;
	
	public PeopleController(PeopleService peopleService) {
		super();
		this.peopleService = peopleService;
	}

	@GetMapping
	public  Iterable<PeopleDto> getAllPeople(){
		List<PeopleDto> peopleDtoList = new ArrayList<>();
		for (People people : peopleService.getAllPeople()) {
			peopleDtoList.add(new PeopleDto(people));
		}
		return peopleDtoList;
	}
	
	@PostMapping(consumes = "application/json")
	public PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto) {
		return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
	}
	
	@DeleteMapping (path="/{id}")
	public void deleteArticle(@PathVariable("id") Long id) {
		peopleService.deleteById(id);
	}
	
}
