package hu.me.iit.licit.Repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface LicitRepository extends PagingAndSortingRepository<Licit, Long>{

	Optional<Licit> findTopByOrderByLicitDesc();

	Optional<Licit> findTopByUserIdOrderByLicitDesc(int userId);


}
