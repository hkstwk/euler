package nl.hkolvoort.euler;

import java.util.ArrayList;

/**
 * @author harm
 * @date 7-June-2015
 * 
 * Project Euler, Problem 14 Largest Collatz Sequence under 1 million
 * 
 */
public class P014_Collatz {
	
	private ArrayList<Long> collatzSequence;
	
	public P014_Collatz(Integer n){
		collatzSequence = fillCollatzSequence(new Long(n));
	}
	
	public ArrayList<Long> fillCollatzSequence(Long n){
		ArrayList<Long> sequence = new ArrayList<Long>();
		
		sequence.add(n);
		while (n>1){
			if (n % 2 == 0){
				n /= 2;
			} 
			else {
				n = 3*n + 1;
			}
			sequence.add(n);
		}
		
		return sequence;
	}
	
	public String getCollatzSequence(){
		StringBuilder sb = new StringBuilder();
		sb.append("Chain length = " + collatzSequence.size() + "\n");
		for (int i=0; i<collatzSequence.size();i++){
			sb.append(collatzSequence.get(i));
			if (i<collatzSequence.size()-1){
				sb.append(" - ");
			}
		}
		return sb.toString();
	}
	
	public int getLength(){
		return collatzSequence.size();
	}
	

	public static void main(String[] args) {
		Integer largestCollatz = 0;
		int maxLength = 1;
		
		for (Integer i=1000000; i>0; i--){
			P014_Collatz col = new P014_Collatz(i);
			if (col.getLength() > maxLength){
				largestCollatz = i;
				maxLength = col.getLength();
			}
		}
		System.out.println(new P014_Collatz(largestCollatz).getCollatzSequence());
	}
}