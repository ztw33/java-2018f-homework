package battlefield;

import creatures.*;
import formation.*;
import java.util.ArrayList;


public class Battlefield {
	ArrayList<Unit<Creature>> units = new ArrayList<>();
	private int width = 15;
	private int length = 15;
	public Battlefield(){
		for (int i=0; i<width; i++) {
			for (int j=0; j<length; j++) {
				units.add(new Unit<Creature>(new Position(j,i)));
			}
		}
	}
	public void place(Unit<Creature> u, Creature c) {
		u.setCreature(c);
	}
	public void place(Position p, Creature c) {
		units.get(p.getX() + width * p.getY()).setCreature(c);
	}
	public void placeQueue(Queue<Creature> q, Formation f) {
		if(q.getLength() != f.getLength()) {
			throw new IllegalArgumentException("The queue doesn't the formation");
		}
		for (int i=0; i<q.getLength(); i++) {
			place(units.get(f.getArray()[i].getX() + width * f.getArray()[i].getY()), q.queue.get(i));
		}
	}
	public void showBattlefield() {
		String chinese = "[\u4e00-\u9fa5]";
		for (int i=0; i<width * length; i++) {
			try {
				System.out.print(units.get(i).getCreature().getName());
				int length = 0;
				for (int p=0; p<units.get(i).getCreature().getName().length(); p++) {
					String temp =units.get(i).getCreature().getName().substring(p, p + 1);
					if (temp.matches(chinese)) {
						length += 2;
					} else {
						length += 1;
					}
				}
				for (int p=0; p<10-length; p++) {
					System.out.print("\0");
				}
			}catch(Exception e) {
				System.out.print("null      ");
			}
			if(i % width == width - 1) {
				System.out.print("\n");
			}
		}
		System.out.println();
	}
	public void clear(Queue<Creature> q, Formation f) {
		if(q.getLength() != f.getLength()) {
			throw new IllegalArgumentException("The queue doesn't the formation");
		}
		for (int i=0; i<q.getLength(); i++) {
			units.get(f.getArray()[i].getX() + width * f.getArray()[i].getY()).setCreature(null);;
		}
	}
	public void changeFormation(Queue<Creature> old, Queue<Creature> next, Formation oldf, Formation nextf) {
		System.out.println("Change Formation:");
		clear(old, oldf);
		placeQueue(next, nextf);
	}
}
