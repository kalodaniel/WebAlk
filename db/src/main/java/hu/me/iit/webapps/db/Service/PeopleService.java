package hu.me.iit.webapps.db.Service;


public interface PeopleService {
	 Iterable<People> getAllPeople();

	People create(People people);
	
	void deleteById(Long id);

	People getById(Long id);

	void save(People people);

	Iterable<? extends People> findAgeOrGreater(int age);
	
}
