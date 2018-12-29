package CalabashBrothers;


public class CalabashBrotherTest {
	public static void main(String[] args)
	{
		CalabashBrother list[] = CalabashBrother.getRandomList().clone();
		for(CalabashBrother i: list)
			System.out.print(i.name() + "." + i.getRank() + " ");
		System.out.println();
		HuluBrotherSort.BubbleSort(list);
		for(CalabashBrother i: list)
			System.out.print(i.name() + "." + i.getRank() + " ");
		System.out.println();

		CalabashBrother list2[] = CalabashBrother.getRandomList().clone();
		for(CalabashBrother i: list2)
			System.out.print(i.name() + "." + i.getRank() + " ");
		System.out.println();
		HuluBrotherSort.BinarySort(list2);
		for(CalabashBrother i: list2)
			System.out.print(i.name() + "." + i.getRank() + " ");
		System.out.println();
		System.out.print("Color Report:");
		for(CalabashBrother i: list2)
			i.ColorReport();
	}
}
