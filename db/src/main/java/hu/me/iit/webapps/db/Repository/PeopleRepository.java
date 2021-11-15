package hu.me.iit.webapps.db.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<People,Long>{
	Iterable<People> findAllByAgeGreaterThanEqual(int age);
}
