package nl.hkolvoort.euler;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * @author harm
 * @date 29-June-2015
 * 
 * Problem 24 Lexicographic Permutations
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one 
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations 
 * are listed numerically or alphabetically, we call it lexicographic order. The 
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012   021   102   120   201   210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 
 * 5, 6, 7, 8 and 9?
 * 
 */
public class P024_LexPermutations {
	
	// source: http://www.nayuki.io/page/next-lexicographical-permutation-algorithm
	static boolean nextPermutation(int[] array) {
	    // Find longest non-increasing suffix
	    int i = array.length - 1;
	    while (i > 0 && array[i - 1] >= array[i])
	        i--;
	    // Now i is the head index of the suffix
	    
	    // Are we at the last permutation already?
	    if (i <= 0)
	        return false;
	    
	    // Let array[i - 1] be the pivot
	    // Find rightmost element that exceeds the pivot
	    int j = array.length - 1;
	    while (array[j] <= array[i - 1])
	        j--;
	    // Now the value array[j] will become the new pivot
	    // Assertion: j >= i
	    
	    // Swap the pivot with j
	    int temp = array[i - 1];
	    array[i - 1] = array[j];
	    array[j] = temp;
	    
	    // Reverse the suffix
	    j = array.length - 1;
	    while (i < j) {
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	        i++;
	        j--;
	    }
	    
	    // Successfully computed the next permutation
	    return true;
	}



	public static void main(String[] args) throws FileNotFoundException {
		int[] array = {0, 1, 2, 3, 4,5, 6, 7, 8, 9};  // Must start at lowest permutation
		int count = 0;
		do {
			count++;
			System.out.println(count + " - " + Arrays.toString(array));
		} while (nextPermutation(array) && count < 1000000);
	}

}
