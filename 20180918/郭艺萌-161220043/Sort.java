package hw.cb.sort;

public class Sort {

	public static void main(String[] args) {
		CalabashFamily cf = new CalabashFamily();		
		boolean isColor = true;
		
		cf.randomOrder();
		cf.printInfo(false);
		cf.bubbleSort();
		cf.printInfo(!isColor);
		
		cf.randomOrder();
		cf.printInfo(false);
		cf.binarySort();
		cf.printInfo(isColor);
	}		

}
