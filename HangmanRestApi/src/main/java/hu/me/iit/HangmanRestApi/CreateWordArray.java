package hu.me.iit.HangmanRestApi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateWordArray {
	public static ArrayList<String> createWordList(String file){
        ArrayList<String> word_list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String word = br.readLine();
            while(word != null){
                word_list.add(word);
                word = br.readLine();
            }
            br.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException i){
            i.printStackTrace();
        }
        return word_list;

    }
}
