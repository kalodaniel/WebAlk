package hu.me.iit.webapps.db;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<People,Long>{
	
}
