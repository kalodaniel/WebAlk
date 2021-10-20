package hu.me.iit.HangmanRestApi;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	 private ArrayList<String> wordList;
	    
    @PostConstruct
    public void init(){
        GamesInit init_games = new GamesInit();
        this.wordList = init_games.getWordList();
    }
    
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public StartedGame startGame(HttpSession session){
        List<Game> games = getCurrentGames(session);
        Game newGame = new Game(wordList);
        games.add(newGame);
        return new StartedGame(newGame);
    }
    
    @ExceptionHandler(GameOverException.class)
    private ResponseEntity<GameOverInfo> gameOver()
    {
        String s = "Game is already complete";
        GameOverInfo error = new GameOverInfo(s);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    private List<Game> getCurrentGames(HttpSession session) {
        List<Game> games = (List<Game>) session.getAttribute("games");

        if (games == null) {
            games = new ArrayList<>();
            session.setAttribute("games", games);
        }
        return games;
    }
    
    @RequestMapping(value = "/guess", method = RequestMethod.POST, headers="Accept=application/json", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> makeGuess (@RequestBody Guess gameAndLetter, HttpSession session) throws GameDoesNotExistException, InvalidCharacterException {
        String game = gameAndLetter.getGame();
        String guess = gameAndLetter.getGuess();
        Game g = getGame(game, session);
        String gameId = g.getId();
        GameStatus stat = g.getStatus();
        if (!(stat == null)) {
            switch (stat) {
                case ACTIVE:
                    break;
                case WON:
                    return gameOver();
                case LOST:
                    return gameOver();
            }
        }

        if (gameId.equals(game) && guess.length() > 0) {
            char ch = cleanUp(guess);
            boolean correct = compareWords(ch, g);

            if (!correct) {
                g.incIncorrect_guesses();

            } else {
                //change game's guessed word
                g.setGuessedWord(ch);

            }
            g.setStatus();

        } else {
            if (!gameId.equals(game)) {
                throw new GameDoesNotExistException(game);
            } else {
                throw new InvalidCharacterException(guess);
            }
        }
        return new ResponseEntity<>(g, HttpStatus.OK);

    }
    
    private Game getGame(String id, HttpSession session) throws GameDoesNotExistException{
        List<Game> games = (List<Game>) session.getAttribute("games");
        Game g = null;
        for(int i = 0; i < games.size(); i++){
            g = games.get(i);
            if(g.getId().equals(id)){
                break;
            }
        }
        if (g == null) {
            throw new GameDoesNotExistException(id);
        }
        return g;
    }
    private char cleanUp(String c){
        //automatically turn letter to lowercase
        String guess = c.toLowerCase();
        char ch = guess.charAt(0);
        return ch;
    }
    private boolean compareWords(char ch, Game g){
        String word = g.getWord();
        boolean correct;
        CharSequence cs = Character.toString(ch);
        //check if word contains given char
        if(word.contains(cs)){
            correct = true;
        }
        //increase incorrect guesses if it does not
        else{
            correct = false;
        }
        return correct;

    }
}
