package hu.me.iit.HangmanRestApi;

public class GameDoesNotExistException extends Exception {
	public GameDoesNotExistException(String id){
	    super(String.format("Game with id: %s does not exist.", id));
	}
}
