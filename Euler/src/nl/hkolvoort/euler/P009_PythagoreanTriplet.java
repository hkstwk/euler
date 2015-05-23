package nl.hkolvoort.euler;

/**
 * @author Harm Kolvoort
 * @date 23-May-2015
 * 
 * Problem 9: Special Pythagorean triplet
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * 
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 */


public class P009_PythagoreanTriplet {
	
	public static boolean isPtyhagoreanTriple(Integer a, Integer b, Integer c){
		if ((a<b && b<c) && (a*a + b*b == c*c)){
			return true;
		}
		return false;
	}
	
	public int[] findSpecialTriplet(){
		int[] abc = {};
		for (int a =1; a<1000; a++){
			for (int b=1;b<1000;b++){
				for (int c=1;c<1000;c++){
					if (P009_PythagoreanTriplet.isPtyhagoreanTriple(a, b, c) && (a+b+c == 1000)){
						abc = new int[] {a,b,c};
					}
				}
			}
		}
		return abc;
	}
	
	
    public static void main(String[] args){
    	System.out.println(P009_PythagoreanTriplet.isPtyhagoreanTriple(3, 4, 6));
    	
    	int[] triple = new P009_PythagoreanTriplet().findSpecialTriplet();
    	int sum = triple[0]+triple[1]+triple[2];
    	int product = triple[0]*triple[1]*triple[2];
    	System.out.println("a = "  + triple[0] + " b = " + triple[1] + " c = " + triple[2] + " = " +  sum + " product abc = " + product);
    }
}
