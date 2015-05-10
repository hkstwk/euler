package nl.hkolvoort.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P18_MaxSumPath {

	private ArrayList<ArrayList<Integer>> intTriangle;
	public ArrayList<ArrayList<Integer>> getIntTriangle() {
		return intTriangle;
	}

	public void setIntTriangle(ArrayList<ArrayList<Integer>> intTriangle) {
		this.intTriangle = intTriangle;
	}

	public ArrayList<ArrayList<Integer>> getIntTriangleBig() {
		return intTriangleBig;
	}

	public void setIntTriangleBig(ArrayList<ArrayList<Integer>> intTriangleBig) {
		this.intTriangleBig = intTriangleBig;
	}

	private ArrayList<ArrayList<Integer>> intTriangleBig;
		
	/**
	 * Constructor sets sum to zero.
	 * Initialize small tester triangle 
	 * @throws FileNotFoundException 
	 */
	public P18_MaxSumPath() throws FileNotFoundException {
		ArrayList<Integer> helperList1 = new ArrayList<Integer>();
		ArrayList<Integer> helperList2 = new ArrayList<Integer>();
		ArrayList<Integer> helperList3 = new ArrayList<Integer>();
		ArrayList<Integer> helperList4 = new ArrayList<Integer>();
		
		this.intTriangle = new ArrayList<ArrayList<Integer>>();
		
		helperList1.add(3);
		intTriangle.add(helperList1);
				
		helperList2.add(7);
		helperList2.add(4);
		intTriangle.add(helperList2);
		
		helperList3.add(2);
		helperList3.add(4);
		helperList3.add(6);
		intTriangle.add(helperList3);
		
		helperList4.add(8);
		helperList4.add(5);
		helperList4.add(9);
		helperList4.add(3);
		intTriangle.add(helperList4);
		
		loadTriangleFile();
	}
	
	public void loadTriangleFile() throws FileNotFoundException{
	    // read p18.txt
	    // create Scanners 
	    Scanner fileScanner = new Scanner(new File("C:\\Users\\Harm\\Documents\\p18.txt"));
	    Scanner lineScanner;
	    
	    // Initialize ArrayList to store triangle in
	    this.intTriangleBig = new ArrayList<ArrayList<Integer>>();
	    Integer index = 0; // used to add Integers to correct index of ArrayList 
	    
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
				System.out.println(i + " " + j + ": " + intTriangle.get(i).get(j));
			}
		}
		return intTriangle.get(0).get(0);
	}
	
    public static void main(String[] args) throws FileNotFoundException {
        P18_MaxSumPath p18 = new P18_MaxSumPath();
        p18.printTriangle(p18.intTriangle);
        System.out.println(Integer.toString(p18.findMaxSum(p18.intTriangle)));
        p18.printTriangle(p18.intTriangleBig);
        System.out.println(Integer.toString(p18.findMaxSum(p18.intTriangleBig)));
        
    }
}
