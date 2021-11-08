package hu.me.iit.webapps.db.Service;


public interface PeopleService {
	 Iterable<People> getAllPeople();

	People create(People people);
	
	void deleteById(Long id);
	
}
