package nl.hkolvoort.euler;

/**
 * @author Harm Kolvoort
 * @date 28-May-2015
 * 
 * Problem 11: Largest Product in Grid
 * 
 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
 * 
 * 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
 * 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
 * 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
 * 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
 * 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
 * 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
 * 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
 * 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
 * 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
 * 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
 * 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
 * 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
 * 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
 * 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
 * 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
 * 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
 * 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
 * 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
 * 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
 * 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
 * 
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696. 
 * What is the greatest product of four adjacent numbers in the same direction (up, down, left,
 * right, or diagonally) in the 20×20 grid?
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class P011_LargestProductInGrid {

	private ArrayList<ArrayList<Integer>> largeNumberArray;
	private ArrayList<String> lines;
	private ArrayList<Product> products;
	private Integer maxProductIndex;
	private Integer digits;
	
	class Product {
		private Integer start;
		private Long product;
		
		public Product(){
			setStart(0);
			setProduct(new Long(1));
		}

		public Integer getStart() {
			return start;
		}

		public void setStart(Integer start) {
			this.start = start;
		}

		public Long getProduct() {
			return product;
		}

		public void setProduct(Long product) {
			this.product = product;
		}
	}
	
	/**
	 * Constructor: create triangle ArrayList
	 */
	public P011_LargestProductInGrid() throws FileNotFoundException {
		this.largeNumberArray = new ArrayList<ArrayList<Integer>>();
		this.lines = new ArrayList<String>();
		this.products = new ArrayList<Product>();
		this.maxProductIndex = 0;
		this.digits = 0;
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
	
	public void convertLines(){
		Iterator<String> itr = this.lines.iterator();
		ArrayList<Integer> numberList;
		int index =0;
		while (itr.hasNext()){
		    // create Scanners 
		    Scanner lineScanner = extracted(itr).useDelimiter(" ");
		    this.largeNumberArray.add(index,new ArrayList<Integer>());
		    numberList = new ArrayList<Integer>();
			while (lineScanner.hasNext()){
				numberList.add(Integer.parseInt(lineScanner.next()));
			}
		    lineScanner.close();
			this.largeNumberArray.add(index,numberList);
		    index++;
		}
	}


	private Scanner extracted(Iterator<String> itr) {
		return new Scanner(itr.next());
	}
	
	public Integer maxProductHorizontal(ArrayList<ArrayList<Integer>> matrix){
		Integer maxProduct = 0;
		for (int i=0; i<matrix.get(i).size(); i++){
			for (int j=0; j<matrix.get(i).size()-4;j++){
				maxProduct = Math.max(maxProduct,  matrix.get(i).get(j) *
					   matrix.get(i).get(j+1) *
					   matrix.get(i).get(j+2) *
					   matrix.get(i).get(j+3));
			}
		}
		return maxProduct;
	}
	
	public Integer maxProductVertical(ArrayList<ArrayList<Integer>> matrix){
		Integer maxProduct = 0;
		for (int i=0; i<matrix.get(i).size()-3; i++){
			for (int j=0; j<matrix.get(i).size();j++){
				maxProduct = Math.max(maxProduct,  matrix.get(i).get(j) *
					   matrix.get(i+1).get(j) *
					   matrix.get(i+2).get(j) *
					   matrix.get(i+3).get(j));
			}
		}
		return maxProduct;
	}
	
	public Integer maxProductDiagonal1(ArrayList<ArrayList<Integer>> matrix){
		Integer maxProduct = 0;
		for (int i=0; i<matrix.get(i).size()-3; i++){
			for (int j=3; j<matrix.get(i).size();j++){
				maxProduct = Math.max(maxProduct,  matrix.get(i).get(j) *
					   matrix.get(i+1).get(j-1) *
					   matrix.get(i+2).get(j-2) *
					   matrix.get(i+3).get(j-3));
			}
		}
		return maxProduct;
	}
	
	public Integer maxProductDiagonal2(ArrayList<ArrayList<Integer>> matrix){
		Integer maxProduct = 0;
		for (int i=0; i<matrix.get(i).size()-3; i++){
			for (int j=0; j<matrix.get(i).size()-3;j++){
				maxProduct = Math.max(maxProduct,  matrix.get(i).get(j) *
					   matrix.get(i+1).get(j+1) *
					   matrix.get(i+2).get(j+2) *
					   matrix.get(i+3).get(j+3));
			}
		}
		return maxProduct;
	}
	
	public void printSolution(){
		System.out.print("The " + this.digits + " adjacent digits in the 1000-digit number that have the greatest product are ");	
		for (int i=0; i<this.digits;i++){
			System.out.print(this.largeNumberArray.get(this.maxProductIndex+i));
			if (i < this.digits-1){
				System.out.print(" x " );
			};
		}
		System.out.print(" = " + this.getMaxProduct());
		System.out.println("  / Starting at position " + this.getMaxProductIndex());
	}
	
	public Long getMaxProduct(){
		return this.products.get(this.maxProductIndex).getProduct();
	}
	
	public Integer getMaxProductIndex(){
		return this.products.get(this.maxProductIndex).getStart();
	}

	public void printLargeNumberArray(ArrayList<ArrayList<Integer>> lna){ 
		for (int i=0; i<lna.get(i).size(); i++){
			for (int j=0; j<lna.get(i).size();j++){
				System.out.print(lna.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public void printLines(){ 
		Iterator<String> itr = this.lines.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
    public static void main(String[] args) throws FileNotFoundException {
        P011_LargestProductInGrid p011 = new P011_LargestProductInGrid();
        p011.loadLines("/Users/harm/Documents/Eclipse/P011_euler.txt");
        p011.convertLines();
        p011.printLargeNumberArray(p011.largeNumberArray);
        System.out.println("Max product horizontal is: " + p011.maxProductHorizontal(p011.largeNumberArray));
        System.out.println("Max product vertical is: " + p011.maxProductVertical(p011.largeNumberArray));
        System.out.println("Max product diagonal (1) is: " + p011.maxProductDiagonal1(p011.largeNumberArray));
        System.out.println("Max product diagonal (2) is: " + p011.maxProductDiagonal2(p011.largeNumberArray));
    }
}
