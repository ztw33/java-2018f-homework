package battlefield;

import java.util.Random;

import creature.*;

public class Queue {
	public Creature[] queue;
	Queue(){
		this.queue = new Creature[0];
	}
	public Queue(String[] namelist) {
		this.queue = new Creature[namelist.length];
		for (int i=0; i<namelist.length; i++) {
			this.queue[i] = recognizeClass(namelist[i]);
		}
	}
	public void printQueue() {
		for (int i=0; i<this.queue.length; i++) {
			System.out.print(this.queue[i].getName() + " ");
		}
	}
	public Creature recognizeClass(String name) {
		switch (name) {
		case "Grandpa":
			return new Grandpa();
		case "Minion":
			return new Minion();
		case "Scorpion":
			return new Scorpion();
		case "Serpent":
			return new Serpent();
		case "0":
			return new CalabashBrother(CalabashBrotherMask.RED);
		case "1":
			return new CalabashBrother(CalabashBrotherMask.ORANGE);
		case "2":
			return new CalabashBrother(CalabashBrotherMask.YELLOW);
		case "3":
			return new CalabashBrother(CalabashBrotherMask.GREEN);
		case "4":
			return new CalabashBrother(CalabashBrotherMask.CYAN);
		case "5":
			return new CalabashBrother(CalabashBrotherMask.BLUE);
		case "6":
			return new CalabashBrother(CalabashBrotherMask.PURPLE);
		default:
			return new Creature();
		}
	}
	public Creature[] randomOrder() {
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
		for (int i=0; i<this.queue.length; i++) {
			if (this.queue[i].index < 0) {
				System.out.print("\nOther creature exists");
				return;
			}
		}
		for (int i = 0; i < this.queue.length; i++) {
			for (int j = 0; j < this.queue.length - 1; j++) {
				if (this.queue[j].index > this.queue[j + 1].index) {
					Creature temp = this.queue[j];
					this.queue[j] = this.queue[j + 1];
					this.queue[j + 1] = temp;
				}
			}
		}
		System.out.println("\ncalaSort results:");
		this.printQueue();
		System.out.println("");
	}
}
