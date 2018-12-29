package sort;

import creature.OneCalabash;

public class Sort {
	private int[] queue = new int[7];
	OneCalabash[] sevenBrothers = new OneCalabash[7];
	public Sort(OneCalabash[] sevenBrothers){
		this.sevenBrothers = sevenBrothers;
	}
	
	private void initQueue() {
		queue[0] = 3;
		queue[1] = 1;
		queue[2] = 6;
		queue[3] = 2;
		queue[4] = 0;
		queue[5] = 4;
		queue[6] = 5;
	}
	public void sortByNo() {
		initQueue();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (sevenBrothers[queue[j]].tellNo() > sevenBrothers[queue[j + 1]].tellNo()) {
					int tmp = queue[j];
					queue[j] = queue[j + 1];
					queue[j + 1] = tmp;
					//System.out.print(sevenBrothers[queue[j + 1]].tellName() + ": "+ (j + 1) + " -> " + (j + 2) + " ");
					//System.out.println(sevenBrothers[queue[j]].tellName() + ": "+ (j + 2) + " -> " + (j + 1));
				}
			}
		}
		//System.out.println("葫芦兄弟开始报数……");
		//for (int i = 0; i < 7; i++) {		
		//	System.out.print(sevenBrothers[queue[i]].tellName() + " ");
		//}
		//System.out.print("\n");
	}
}
