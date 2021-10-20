package hu.me.iit.HangmanRestApi;

public class GameOverException extends Exception
{
    public GameOverException() {
        super(String.format("Game is already complete"));
    }
}