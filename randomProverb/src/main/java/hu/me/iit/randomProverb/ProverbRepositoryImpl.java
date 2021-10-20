package hu.me.iit.randomProverb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ProverbRepositoryImpl implements ProverbRepository {
	private List<String> students = new ArrayList<String>();
	private List<String> proverbs = new ArrayList<String>();
	@Override
	public String getStudent() {
		int rand = generateRandomStudent(); 
		String dir = System.getProperty("user.dir");
	    String fpath = dir + File.separator + "students.txt";
	    this.students = CreateArray.createWordList(fpath);
	    return this.students.get(rand).toString();
	}

	@Override
	public String getProverb() {
		int rand = generateRandomProverb(); 
		String dir = System.getProperty("user.dir");
	    String fpath = dir + File.separator + "proverbs.txt";
	    this.proverbs = CreateArray.createWordList(fpath);
	    return this.proverbs.get(rand).toString();
	}
	
	public int generateRandomProverb() {
		return (int) Math.floor(Math.random() * proverbs.size());
	}
	public int generateRandomStudent() {
		return (int) Math.floor(Math.random() * students.size());
	}
}
