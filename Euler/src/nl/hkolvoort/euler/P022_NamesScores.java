package nl.hkolvoort.euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author harm
 * @date 27-June-2015
 * 
 * Project Euler, Problem 22 Names Scores
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file 
 * containing over five-thousand first names, begin by sorting it into alphabetical order. 
 * Then working out the alphabetical value for each name, multiply this value by its 
 * alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is 
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 */
public class P022_NamesScores {
	
	private static final List<String> alphabet = Arrays.asList("","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
	private ArrayList<String> names = P022_NamesScores.loadNames();
	
	public String toString(){
		return names.toString();
	}
	
	public Integer getPosition(String name){
		return names.indexOf(name)+1;
	}
	
	public Integer getNameSum(String name){
		Integer sum = 0;
		char[] tempName = name.toCharArray();
		for (int i=0; i<tempName.length; i++){
			sum += alphabet.indexOf(String.valueOf(tempName[i]));
		}
		return sum;
	}	
	
	public Integer getNameScore(String name){
		return getPosition(name) * getNameSum(name);
	}
	
	public Long getNameScores(){
		Iterator<String> itr = names.iterator();
		Long totalNameScore = new Long("0");
		while (itr.hasNext()){
			totalNameScore = totalNameScore + (getNameScore(itr.next())) ;
		}
		return totalNameScore;
	}
	
	public static ArrayList<String> loadNames(){
		String csvFile = "/Users/harm/Documents/Eclipse/P022_euler_names.txt";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String> nameList = new ArrayList<String>();

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null){
				String[] names = line.split(csvSplitBy);
				for (int i=0; i< names.length; i++){
					nameList.add(names[i].replace("\"", ""));
				}
			}
			nameList.sort(null);			
		}
		catch (FileNotFoundException e){
			System.out.println("Couldn't find file " + csvFile);
		} catch (IOException e) {
			System.out.println("Error processing BufferedReader");
			e.printStackTrace();
		}
		finally {
			if (br != null){
				try {
					br.close();
				} catch (IOException e){
					System.out.println("CError closing BufferedReader for " + "\"" + csvFile + "\"");
				}
			}
		}
		return nameList;
	}


	public static void main(String[] args) throws FileNotFoundException {
		P022_NamesScores ns = new P022_NamesScores();
		System.out.println(ns.toString());
		
		System.out.println("Name score of COLIN = " + ns.getNameScore("COLIN"));
		System.out.println("Names score of all names = " + ns.getNameScores());
	}

}
