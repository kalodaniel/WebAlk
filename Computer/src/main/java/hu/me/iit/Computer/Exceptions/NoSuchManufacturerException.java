package hu.me.iit.Computer.Exceptions;

public class NoSuchManufacturerException extends RuntimeException {
	
	public NoSuchManufacturerException() {
		super("No such manufacturer");
	}
}
