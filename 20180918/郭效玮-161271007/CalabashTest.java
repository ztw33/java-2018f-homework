
public class CalabashTest {
	public static void main(String[] args) {
		CalabashSorter cal=new CalabashSorter();
		cal.reportName();
		cal.reportColor();
		
		cal.randomList();
		System.out.println("1st_random");
		cal.reportName();
		cal.bubbleSort();
		cal.reportName();
		
		cal.randomList();
		System.out.println("2nd_random");
		cal.reportColor();
		cal.binarySort();
		cal.reportColor();
	}
}
