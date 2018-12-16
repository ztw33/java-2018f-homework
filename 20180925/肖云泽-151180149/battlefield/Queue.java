package battlefield;

import java.util.Random;
import creatures.*;

public class Queue {
	public Creature[] queue;
	public Queue(){
		this.queue = new Creature[0];
	}
	public Queue(Creature c) {
		this.queue = new Creature[1];
		this.queue[0] = c;
	}
	public Queue(Creature[] list) {
		this.queue = new Creature[list.length];
		for (int i=0; i<list.length; i++) {
			this.queue[i] = list[i];
		}
	}
	//for convenience
	public void sevenBrothers() {
		CalabashBrotherMask[] list = CalabashBrotherMask.values();
		this.queue = new Creature[list.length];
		for (int i=0; i<list.length; i++) {
			this.queue[i] = new CalabashBrother(list[i]);
		}
	}
	//for unique function
	public Creature[] randomOrder() {
		if (!this.checkCamp()) {
			return null;
		}
		Random rand = new Random();
		int[] QueueIndex = new int[this.queue.length];
		// get an index code
		for (int i = 0; i < QueueIndex.length; i++) {
			QueueIndex[i] = rand.nextInt(QueueIndex.length - i);
		}
		// decode
		for (int i = 0; i < QueueIndex.length; i++) {
			int m = QueueIndex[i] + i;
			while (true) {
				int temp = 0;
				for (int j = 0; j < i; j++) {
					if (QueueIndex[j] < m) {
						temp += 1;
					}
				}
				if (QueueIndex[i] + temp == m) {
					break;
				}
				m--;
			}
			QueueIndex[i] = m;
		}
		System.out.println("Random order:");
		Creature[] creatures = new Creature[this.queue.length];
		for (int i = 0; i < QueueIndex.length; i++) {
			creatures[i] = this.queue[QueueIndex[i]];
		}
		this.queue = creatures;
		this.printQueue();
		return this.queue;
	}
	
	public void calaSort() {
		if (!this.checkCamp()) {
			return;
		}
		CalabashBrother[] tempqueue = new CalabashBrother[this.queue.length];
		//向下转型
		/*for (int i=0; i<this.queue.length; i++) {
			if (this.queue[i] instanceof CalabashBrother){
				tempqueue[i] = (CalabashBrother)this.queue[i];
	         }
		}*/
		try {
			for (int i=0; i<this.queue.length; i++) {
				if (this.queue[i] instanceof CalabashBrother){
					tempqueue[i] = (CalabashBrother)this.queue[i];
		         }
			}
			for (int i = 0; i < tempqueue.length; i++) {
				for (int j = 0; j < tempqueue.length - 1; j++) {
					if (tempqueue[j].getIndex() > tempqueue[j + 1].getIndex()) {
						CalabashBrother temp = tempqueue[j];
						tempqueue[j] = tempqueue[j + 1];
						tempqueue[j + 1] = temp;
					}
				}
			}
			System.out.println("\ncalaSort results:");
			this.printQueue();
			System.out.println("");
		}catch(Exception e) {
			System.out.print(e + ":");
			System.out.println("calaSort() is only used for CalabashBrother");
			return;
		}
	}
	private boolean checkCamp() {
		int sum = 0;
		for (int i=0; i<this.queue.length; i++) {
			sum += this.queue[i].getCamp();
		}
		if (sum == 0 || sum == this.queue.length) {
			return true;
		}else {
			System.out.println("The Queue has different camp creatures");
			return false;
		}
	}
	
	//functional 
	public void printQueue() {
		for (int i=0; i<this.queue.length; i++) {
			System.out.print(this.queue[i].getName() + " ");
		}
		System.out.println();
	}
	public void appendCreature(Creature c) {
		Creature[] tempqueue = new Creature[this.queue.length + 1];
		for (int i=0; i<this.queue.length; i++) {
			tempqueue[i] = this.queue[i];
		}
		tempqueue[tempqueue.length - 1] = c;
		this.queue = tempqueue;
	}
	
	public void appendQueue(Queue q) {
		Creature[] tempqueue = new Creature[this.queue.length + q.queue.length];
		for (int i=0; i<this.queue.length; i++) {
			tempqueue[i] = this.queue[i];
		}
		for (int i=0; i<q.queue.length; i++) {
			tempqueue[i + this.queue.length] = q.queue[i];
		}
		this.queue = tempqueue;
	}
}
