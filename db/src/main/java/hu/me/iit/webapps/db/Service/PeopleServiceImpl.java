package hu.me.iit.webapps.db.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.me.iit.webapps.db.NoSuchEntityException;
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
		try {
			peopleRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchEntityException(id);
		}
	}

	@Override
	public People getById(Long id) {
		Optional<hu.me.iit.webapps.db.Repository.People> optionalPeople = peopleRepository.findById(id);
		if(optionalPeople.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new People(optionalPeople.get());
	}

	@Override
	public void save(People people) {
		Optional<hu.me.iit.webapps.db.Repository.People> optionalPeople = peopleRepository.findById(people.getId());
		if(optionalPeople.isEmpty()) {
			throw new NoSuchEntityException(people.getId());
		}
		peopleRepository.save(people.toEntity());
	}

	@Override
	public Iterable<? extends People> findAgeOrGreater(int age) {
		List<People> rv = new ArrayList<>();
		for (hu.me.iit.webapps.db.Repository.People people : peopleRepository.findAllByAgeGreaterThanEqual(age)) {
			rv.add(new People(people));
		}
		return rv;
	}

	@Override
	public void patch(People people) {
		Optional<hu.me.iit.webapps.db.Repository.People> optionalPeople = peopleRepository.findById(people.getId());
		if(optionalPeople.isEmpty()) {
			throw new NoSuchEntityException(people.getId());
		}
		else if(people.getName()==null) {
			optionalPeople.get().setAge(people.getAge());
			peopleRepository.save(optionalPeople.get());
		}
		else if(people.getAge()==0) {
			optionalPeople.get().setName(people.getName());
			peopleRepository.save(optionalPeople.get());
		}
		else {
			System.out.println(people.getName());
			peopleRepository.save(people.toEntity());
		}
	}

	
}
