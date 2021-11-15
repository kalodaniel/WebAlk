package hu.me.iit.webapps.db;

public class NoSuchEntityException extends RuntimeException{
	private Long id;

	
	public Long getId() {
		return id;
	}

	public NoSuchEntityException(Long id) {
		super(String.format("No such entity", id));
		this.id = id;
	}
	
}
