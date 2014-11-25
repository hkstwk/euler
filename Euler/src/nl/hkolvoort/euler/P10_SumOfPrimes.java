package nl.hkolvoort.euler;

import java.util.ArrayList;

public class P10_SumOfPrimes {
	private ArrayList<Long> primeList;
	private Long resultSumOfPrimes;
	
	public P10_SumOfPrimes(Long input) {
		primeList = PrimeHelper.fillPrimeArray(input);
		resultSumOfPrimes = PrimeHelper.calculateSumOfPrimes(primeList);
	}
	
	public String getFormattedResult() {
		String resultString = "";
		for (int i=0; i<primeList.size(); i++) {
			resultString += primeList.get(i);
			if (i<primeList.size()-1) {
				resultString += " + ";
			} else {
				resultString += " = ";
			}
		} 
		resultString += resultSumOfPrimes;
		return resultString;
	}
	
	public Long getResult() {
		return resultSumOfPrimes;
	}

	public ArrayList<Long> getPrimeList() {
		return primeList;
	}

	
}
