package huluwa;
import huluwa.Huluwa;
import huluwa.Sort;
import java.util.*;

public class HuluwaQueue {
	Huluwa[] huluwaqueue=Huluwa.values();
	Sort sort=new Sort(huluwaqueue);
	HuluwaQueue(){
		
	}
	public void randomSort(){
		Collections.shuffle(Arrays.asList(huluwaqueue));
	}
	public void bubbleSort_by_ordinal(){
		sort.bubbleSort();
	}
	public void quickSort_by_color_ordinal(){
		sort.quickSort();
	}
	public void printColor(){
        System.out.println("---------- the result is ----------");
		for(Huluwa huluwa:huluwaqueue)
		{
			System.out.println(huluwa.get_color());
		}
		System.out.println();
	}
	public void printName(){
        System.out.println("---------- the result is ----------");
		for(Huluwa huluwa:huluwaqueue)
		{
			System.out.println(huluwa.get_name());
		}
		System.out.println();
	}
	public static void main(String[] args) {
		HuluwaQueue queue=new HuluwaQueue();
		queue.randomSort();
		queue.bubbleSort_by_ordinal();
		queue.printName();
		queue.randomSort();
		queue.quickSort_by_color_ordinal();
		queue.printColor();
	}
}
