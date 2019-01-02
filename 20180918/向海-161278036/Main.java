package sort;

public class Main {
	public static void main(String args[]) {
		CalabashBrothers[] Calabash = new CalabashBrothers[7];
		CalabashQueue queue=new CalabashQueue();
		
		int i=0;
		for(CalabashBrothers h: CalabashBrothers.values()) {
			Calabash[i++]=h;
		}
		queue.RandomSort(Calabash);
		queue.queueClaimName(Calabash);
		queue.BubbleSort(Calabash);
		queue.queueClaimName(Calabash);
		queue.RandomSort(Calabash);
		queue.queueClaimName(Calabash);
		queue.BinarySort(Calabash);		
		queue.queueClaimColor(Calabash);
	}
}