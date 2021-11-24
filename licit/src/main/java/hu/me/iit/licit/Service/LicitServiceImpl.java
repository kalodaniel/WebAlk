package hu.me.iit.licit.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import hu.me.iit.licit.Repository.LicitRepository;

@Service
public class LicitServiceImpl implements LicitService {

	private LicitRepository licitRepository;
	
	public LicitServiceImpl(LicitRepository licitRepository) {
		this.licitRepository = licitRepository;
	}

	@Override
	public Integer findHighest() {
		Optional<hu.me.iit.licit.Repository.Licit> optionalLicit = licitRepository.findTopByOrderByLicitDesc();
		if(optionalLicit.isEmpty())
			return 0;
		return optionalLicit.get().getLicit();
	}

	@Override
	public Integer findHighestByUser(int userId) {
		Optional<hu.me.iit.licit.Repository.Licit> optionalLicit = licitRepository.findTopByUserIdOrderByLicitDesc(userId);
		if(optionalLicit.isEmpty())
			return 0;
		return optionalLicit.get().getLicit();
	}

	@Override
	public void save(Licit licit) {
		licitRepository.save(licit.toEntity());

	}

}
