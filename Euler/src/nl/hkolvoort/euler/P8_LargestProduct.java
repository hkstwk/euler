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

	
	class Product {
		private Integer start;
		private Integer stop;
		private Integer product;
		
		public Product(){
			setStart(0);
			setStop(0);
			setProduct(0);
		}

		public Integer getStart() {
			return start;
		}

		public void setStart(Integer start) {
			this.start = start;
		}

		public Integer getStop() {
			return stop;
		}

		public void setStop(Integer stop) {
			this.stop = stop;
		}

		public Integer getProduct() {
			return product;
		}

		public void setProduct(Integer product) {
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

	}
		
	public ArrayList<Integer> getIntTriangleBig() {
		return largeNumberArray;
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
				this.largeNumberArray.add(Integer.parseInt(String.valueOf(line.charAt(i))));
			}
		}
	}
	
	public void calcProducts(){
		Integer tempMax = 0;
		Product prod;
		
		for (int i=0; i<this.largeNumberArray.size()-4;i++){
			prod = new Product();
			prod.setStart(i);
			prod.setStop(i+3);
			prod.setProduct(this.largeNumberArray.get(prod.getStart()) *
							this.largeNumberArray.get(prod.getStart()+1) * 
							this.largeNumberArray.get(prod.getStart()+2) *
							this.largeNumberArray.get(prod.getStop()));
			this.products.add(prod);
			if (prod.getProduct() > tempMax){
				tempMax = prod.getProduct();
				this.maxProductIndex = this.products.size()-1;
			}
		}
	}
	
	public Integer getMaxProduct(){
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
        p8.loadLines("/Users/harm/Documents/Eclipse/P008_euler.txt");
        p8.convertLines();
        p8.printLargeNumberArray(p8.largeNumberArray);
        p8.calcProducts();
        System.out.println("The maximum product is: " + p8.getMaxProduct());
        System.out.println("The maximum product starts at index : " + p8.getMaxProductIndex());
    }
}
