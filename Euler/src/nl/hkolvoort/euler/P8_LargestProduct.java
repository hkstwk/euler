package nl.hkolvoort.euler;

/**
 * @author Harm Kolvoort
 * @date 11-5-2015
 * 
 * Problem 18: Maximum path sum I (triangle with 15 rows) 
 * Problem 67: Maximum path sum II (triangle with 100 rows; brute force won't work here
 * 
 * By starting at the top of the triangle and moving to adjacent numbers on the row below, 
 * find the maximum total from top to bottom.
 * 
 * Number of routes is 2^n-1, where n is numbers of rows in the triangle.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P8_LargestProduct {

	private ArrayList<Integer> largeNumberArray;
	private ArrayList<String> lines;
	
	/**
	 * Constructor: create triangle ArrayList
	 */
	public P8_LargestProduct() throws FileNotFoundException {
		this.largeNumberArray = new ArrayList<Integer>();
		this.lines = new ArrayList<String>();
	}
		
	public ArrayList<Integer> getIntTriangleBig() {
		return largeNumberArray;
	}
	
	public void readFileByLine(String fileName) {
		  try {
		   File file = new File(fileName);
		   Scanner scanner = new Scanner(file);
		   while (scanner.hasNext()) {
		    System.out.println(scanner.next());
		   }
		   System.out.println();
		   scanner.close();
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  } 
		 }

	public void loadLines(String fileName) throws FileNotFoundException{
	    // create Scanners 
	    Scanner fileScanner = new Scanner(new File(fileName));
	    
	    // while loop for file scanner. Continue till last line.
	    while (fileScanner.hasNextLine()){
	      this.lines.add(fileScanner.nextLine());
	    }
	    fileScanner.close();
	  }

	public void printLargeNumberArray(ArrayList<Integer> lna){ 
		for (int i=0; i<lna.size(); i++){
			System.out.print(lna.get(i));
			if (i % 49 == 0){
				System.out.println();
			}
		}
	}
	
	public void printLines(){ 
		for (int i=0; i<lines.size(); i++){
			System.out.println(this.lines.get(i));
		}
	}
	
	public Integer findMaxSum(ArrayList<ArrayList<Integer>> intTriangle) {
		for (int i=intTriangle.size()-2;i>=0;i--){
			for (int j=0; j<intTriangle.get(i).size();j++){
				intTriangle.get(i).set(j, intTriangle.get(i).get(j) + Math.max(intTriangle.get(i+1).get(j), intTriangle.get(i+1).get(j+1)));
			}
		}
		return intTriangle.get(0).get(0);
	}
	
    public static void main(String[] args) throws FileNotFoundException {
        P8_LargestProduct p8 = new P8_LargestProduct();
        //p8.readFileByLine("/Users/harm/Documents/Eclipse/P008_euler.txt");
        p8.loadLines("/Users/harm/Documents/Eclipse/P008_euler.txt");
        p8.printLines();
    }
}
