package hu.me.iit.Computer.Exceptions;

public class NoSuchEntityException extends RuntimeException{

	public NoSuchEntityException() {
		super(String.format("No such entity"));
	}
}
