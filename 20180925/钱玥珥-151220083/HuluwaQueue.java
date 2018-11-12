package square;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuluwaQueue {
	private Member [][]queue;
	HuluwaQueue(){
		queue=new Member[7][1];
		requeue();
	}
	private void queueUp() {
		List<Integer> list=new ArrayList<Integer>();
		for(int i = 1;i<=7;i++)
			list.add(i);
		Collections.shuffle(list);
		for(int i = 0;i<=6;i++) {
			queue[i][0]=Member.values()[list.get(i)];
		}
	}
	
	public void requeue() {
		queueUp();
	}
	
	public Member[][] getQueue() {
		return queue;
	}
}
