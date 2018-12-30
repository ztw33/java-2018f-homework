package battlefield;

import creatures.*;
import java.util.ArrayList;
import java.util.Collections;

public class Queue <T extends Creature>{
	public ArrayList<T> queue = new ArrayList<>();
	public Queue(){		
	}
	public Queue(T[] creaturelist) {
		for (T c : creaturelist) {
			queue.add(c);
		}
	}
	public void add(T t) {
		queue.add(t);
	}
	public void randomOrder() {
		Collections.shuffle(queue);
		System.out.println("Random order:");
		printQueue();
		
	}
	public void calaSort() {
		for (T t : queue) {
			if (t.getClass() != CalabashBrother.class)
			{
				throw new IllegalArgumentException("the calaSort() is used for CalabashBrother");
			}
		}
		ArrayList<T> copyqueue = new ArrayList<>();
		for (T c : queue) {
			copyqueue.add(c);
		}
		ArrayList<CalabashBrother> tempqueue = new ArrayList<>();
		for (T c : queue) {
			CalabashBrother x = (CalabashBrother)c;
			tempqueue.add(x);
		}
		for (int i = 0; i < this.getLength(); i++) {
			for (int j = 0; j < this.getLength() - 1; j++) {
				if (tempqueue.get(j).getIndex() > tempqueue.get(j + 1).getIndex()) {
					CalabashBrother temp1 = tempqueue.get(j);
					tempqueue.set(j, tempqueue.get(j + 1));
					tempqueue.set(j + 1, temp1);
					T temp2 = queue.get(j);
					queue.set(j, queue.get(j + 1));
					queue.set(j + 1, temp2);
				}
			}
		}
		System.out.println("calaSort results:");
		this.printQueue();
	}
	public int getLength() {
		return queue.size();
	}
	public void printQueue() {
		for (T t : queue) {
			System.out.print(t.getName() + " ");
		}
		System.out.println();
	}
}
