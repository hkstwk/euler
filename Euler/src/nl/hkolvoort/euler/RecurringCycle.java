package nl.hkolvoort.euler;

import java.util.List;

public class RecurringCycle {
	private Integer denominator;
	private Integer length;
	private List<Integer> repeatingDecimals;
	
	public RecurringCycle(){
		setLength(0);
		setRepeatingDecimals(null);
	}
	
	public Integer getDenominator() {
		return denominator;
	}

	public void setDenominator(Integer denominator) {
		this.denominator = denominator;
	}

	public void setLength(Integer length){
		this.length = length;
	}
	
	public Integer getLength() {
		return length;
	}

	public List<Integer> getRepeatingDecimals() {
		return repeatingDecimals;
	}

	public void setRepeatingDecimals(List<Integer> repeatingDecimals) {
		this.repeatingDecimals = repeatingDecimals;
	}
	
	public String toString(){
		return "Denominator = " + denominator + " / Length = " + length + " / " + repeatingDecimals.toString();
	}
}