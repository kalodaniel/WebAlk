package hu.me.iit.webapps.db.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.me.iit.webapps.db.Repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {

	private final PeopleRepository peopleRepository;
	
	public PeopleServiceImpl(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	@Override
	public Iterable<People> getAllPeople() {
		List<People> rv = new ArrayList<>();

		for (hu.me.iit.webapps.db.Repository.People people : peopleRepository.findAll()) {
			rv.add(new People(people));
		}
		return rv;
	}

	@Override
	public People create(People people) {
		return new People(peopleRepository.save(people.toEntity()));
	}

	@Override
	public void deleteById(Long id) {
		peopleRepository.deleteById(id);
	}
}
