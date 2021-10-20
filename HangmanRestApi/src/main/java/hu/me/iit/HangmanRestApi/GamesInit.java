package hu.me.iit.HangmanRestApi;

import java.io.File;
import java.util.ArrayList;

public class GamesInit {
	 private ArrayList<String> word_list;

	    public GamesInit() {
	        String dir = System.getProperty("user.dir");
	        String fpath = dir + File.separator + "words.txt";
	        this.word_list = CreateWordArray.createWordList(fpath);
	    }

	    public ArrayList<String> getWordList(){
	        return this.word_list;
	    }
}
