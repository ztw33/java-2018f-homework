package huluwa;

public class tree {
	public static void main (String[] args)
	{
		list huluwas=new list();
		System.out.println("随意：");
		huluwas.start();
		huluwas.printNo();
		huluwas.printColor();
		
		System.out.println("冒泡：");
		huluwas.Bsort();
		huluwas.printNo();
		
		System.out.println("随意：");
		huluwas.start();
		huluwas.printNo();
		huluwas.printColor();
		
		System.out.println("二分法：");
		huluwas.BIsort();
		huluwas.printColor();
		
		
	}
}
