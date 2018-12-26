package second_homework;

public class Entrance {
	public static void main(String[] args) {
		CalabashBrothers calabashbrothers=CalabashBrothers.GetCalabashBrothers();
		Sort randomize=new Randomize();
		Sort bubblesort=new BubbleSort();
		Sort binarysort=new BinarySort();
		randomize.sort(calabashbrothers);
		System.out.print("Randomization result:");
		calabashbrothers.countoffbystatus();
		bubblesort.sort(calabashbrothers);
		System.out.print("bubblesort result:");
		calabashbrothers.countoffbystatus();
		randomize.sort(calabashbrothers);
		System.out.print("Randomization result:");
		calabashbrothers.countoffbystatus();
		binarysort.sort(calabashbrothers);
		System.out.print("binarysort result:");
		calabashbrothers.countoffbycolor();
	}
}
