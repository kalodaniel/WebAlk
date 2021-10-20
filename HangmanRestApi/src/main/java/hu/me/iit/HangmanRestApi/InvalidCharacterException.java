package hu.me.iit.HangmanRestApi;

public class InvalidCharacterException extends Exception {
	 public InvalidCharacterException(String s){
	     super(String.format("Guessed character %s is invalid.", s));
	 }
}
