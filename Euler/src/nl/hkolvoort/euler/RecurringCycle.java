package nl.hkolvoort.euler;

import java.util.Iterator;
import java.util.List;


public class RecurringCycle {
	private Integer denominator;
	private Integer length;
	private Integer beginPosition;
	private Integer endPosition;
	private List<Integer> longDivisionDecimals;
	
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

	public Integer getBeginPosition() {
		return beginPosition;
	}

	public void setBeginPosition(Integer beginPosition) {
		this.beginPosition = beginPosition;
	}

	public Integer getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Integer endPosition) {
		this.endPosition = endPosition;
	}

	public List<Integer> getRepeatingDecimals() {
		return longDivisionDecimals;
	}

	public void setRepeatingDecimals(List<Integer> repeatingDecimals) {
		this.longDivisionDecimals = repeatingDecimals;
	}
	
	private String convertString(List<Integer> list){
		Iterator<Integer> itr = list.iterator();
		boolean isFirstInteger = true;
		StringBuilder sb = new StringBuilder();
		while (itr.hasNext()){
			sb.append(Integer.toString(itr.next()));
			if (isFirstInteger){
				sb.append(",");
				isFirstInteger = false;
			}
		}
		return sb.toString();
	}
	
	public String toString(){
		return "Denominator = " + denominator + 
			   " / Length = " + length +
			   " / Beginning at " + beginPosition +
			   " / Ending at " + endPosition +
			   " / " +convertString(longDivisionDecimals);
	}
}