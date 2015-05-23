package nl.hkolvoort.euler;

/**
 * @author Harm Kolvoort
 * @date 11-5-2015
 * 
 * Problem 8: 
 * 
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * 
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 * 
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. 
 * What is the value of this product?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class P8_LargestProduct {

	private ArrayList<Integer> largeNumberArray;
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
	public P8_LargestProduct() throws FileNotFoundException {
		this.largeNumberArray = new ArrayList<Integer>();
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
		String line;
		while (itr.hasNext()){
			line = itr.next();
			for (int i=0; i<line.length(); i++){
				this.largeNumberArray.add(Character.getNumericValue(line.charAt(i)));
			}
		}
	}
	
	public void calcProducts(Integer digits){
		Long tempMax = new Long(0);
		Product prod;
		this.products.clear();
		this.digits = digits;
		
		for (int i=0; i<this.largeNumberArray.size()-digits;i++){
			prod = new Product();
			prod.setStart(i);
			for (int j=0; j<digits; j++){
				prod.setProduct(prod.getProduct() * this.largeNumberArray.get(prod.getStart()+j));
			}
			this.products.add(prod);
			if (prod.getProduct() > tempMax){
				tempMax = prod.getProduct();
				this.maxProductIndex = this.products.size()-1;
			}
		}
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

	public void printLargeNumberArray(ArrayList<Integer> lna){ 
		for (int i=0; i<lna.size(); i++){
			if ((i>0) && (i % 50 == 0)){
				System.out.println();
			}
			System.out.print(lna.get(i));
		}
		System.out.println();
	}
	
	public void printLines(){ 
		Iterator<String> itr = this.lines.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
    public static void main(String[] args) throws FileNotFoundException {
        P8_LargestProduct p8 = new P8_LargestProduct();
        p8.loadLines("/Users/harm/Documents/Eclipse/P008_euler.txt");
        p8.convertLines();
        p8.printLargeNumberArray(p8.largeNumberArray);
        p8.calcProducts(4);
        p8.printSolution();
        p8.calcProducts(13);  
        p8.printSolution();
        p8.calcProducts(18);  
        p8.printSolution();
    }
}
