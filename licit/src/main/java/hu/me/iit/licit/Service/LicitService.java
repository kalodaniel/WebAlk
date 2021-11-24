package hu.me.iit.licit.Service;

public interface LicitService {

	Integer findHighest();

	Integer findHighestByUser(int userId);

	void save(Licit licit);

}
