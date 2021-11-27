package hu.me.iit.Computer.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComputerRepository extends PagingAndSortingRepository<Computer, Long>{

	Iterable<Computer> findAllByAgeGreaterThanEqual(Integer age);

	Iterable<Computer> findAllByManufacturerLike(String manufacturer);

	Computer findTopByOrderByAgeDesc();

	Computer findTopByOrderByAgeAsc();

	Computer findTopByManufacturerLikeOrderByAgeDesc(String manufacturer);

}
