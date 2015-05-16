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

public class P18_MaxSumPath {

	private ArrayList<ArrayList<Integer>> intTriangleBig;
	
	/**
	 * Constructor: create triangle ArrayList
	 */
	public P18_MaxSumPath() throws FileNotFoundException {
		this.intTriangleBig = new ArrayList<ArrayList<Integer>>();
	}
		
	public ArrayList<ArrayList<Integer>> getIntTriangleBig() {
		return intTriangleBig;
	}

	public void loadTriangleFile(String fileName) throws FileNotFoundException{
	    // create Scanners 
	    Scanner fileScanner = new Scanner(new File(fileName));
	    Scanner lineScanner;
	    
	    // clear triangle ArrayList if not empty
	    if (!this.intTriangleBig.isEmpty()){
	    	this.intTriangleBig.clear();
	    }
	    Integer index = 0; // used to add Integers to correct index of ArrayList (= row of triangle) 
	    
	    // while loop for file scanner. Continue till last line.
	    while (fileScanner.hasNextLine()){
	      lineScanner = new Scanner(fileScanner.nextLine());
	      index = intTriangleBig.size();
	      intTriangleBig.add(index, new ArrayList<Integer>());
	      while (lineScanner.hasNextInt()){
	    	  intTriangleBig.get(index).add(lineScanner.nextInt());
	      }
	      lineScanner.close();
	    }
	    fileScanner.close();
	  }

	public void printTriangle(ArrayList<ArrayList<Integer>> intTriangle){ 
		for (int i=0; i<intTriangle.size(); i++){
			for (int j=0; j<intTriangle.get(i).size();j++){
				System.out.print(intTriangle.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
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
        P18_MaxSumPath p18 = new P18_MaxSumPath();
        //p18.loadTriangleFile("C:\\Users\\Harm\\Documents\\p067_triangle.txt");
        p18.loadTriangleFile("C:\\Users\\Harm\\Documents\\p18.txt");
        p18.printTriangle(p18.intTriangleBig);
        System.out.println("The maximum total of all routes through triangle is: " + p18.findMaxSum(p18.intTriangleBig));
        
    }
}
