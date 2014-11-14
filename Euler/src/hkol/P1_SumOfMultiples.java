package hkol;

public class P1_SumOfMultiples {
	private Integer sum;
	
	public P1_SumOfMultiples() {
		sum = 0;
	}
	
	public boolean isMultiple(Integer number, Integer divider) {
		if (number % divider == 0) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Method to determine sum of multiples
	 * @param multiple1
	 * @param multiple2
	 * @param limit
	 * @return
	 */
	public Integer sum(Integer multiple1, Integer multiple2, Integer limit) {
		for (int i=1; i<=limit; i++) {
			if (isMultiple(i,multiple1) || isMultiple(i,multiple2)){
				sum += i;
			}
		}
		return sum;
	}

}
