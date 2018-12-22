package battlefield;

import creatures.*;
import formation.*;

public class Battlefield {
	private Unit[] unit;
	private int scale;
	public Battlefield() {
		this.unit = null;
		this.scale = 0;
	}
	public Battlefield(int scale) {
		this.scale = scale;
		this.unit = new Unit[scale * scale];
		for (int i=0; i<scale; i++) {
			for (int j=0; j<scale; j++) {
				unit[j*scale + i] = new Unit(new Position(i, j));
			}
		}
	}
	public void place(Position p, Creature c) {
		this.searchUnit(p).setCreature(c);
	}
	public void place(Formation f, Position offset, Queue q) {
		if(f.getLength() != q.queue.length)
		{
			System.out.println("Formation doesn't mastch Queue");
			return;
		}
		for (int i=0; i<q.queue.length; i++) {
			this.place(f.getPosition()[i].add(offset), q.queue[i]);
			this.searchUnit(f.getPosition()[i].add(offset)).setQ(q);
		}
	}
	public void remove(Unit u) {
		u.setCreature(new Creature());
		u.setQ(new Queue());
	}
	public void changeFormation(Formation target, Queue q, Formation old, Position offset) {
		System.out.println("Next Formation:");
		if(target.getLength() != q.queue.length)
		{
			System.out.println("Formation doesn't match Queue");
			return;
		}
		for (int i=0; i<q.queue.length; i++) {
			try {
				this.remove(this.searchUnit(old.getPosition()[i].add(offset)));
			}catch(Exception e) {
				
			}
			}
		for (int i=0; i<q.queue.length; i++) {
			this.place(target.getPosition()[i].add(offset), q.queue[i]);
			this.searchUnit(target.getPosition()[i].add(offset)).setQ(q);
		}
	}
	public Unit searchUnit(Position p) {
		for (int i=0; i<this.unit.length; i++) {
			if(this.unit[i].getPosition().getX() == p.getX() && this.unit[i].getPosition().getY() == p.getY()) {
				return this.unit[i];
			}
		}
		System.out.println("Can't find the unit");
		return null;
	}
	public void showBattlefield() {
		String chinese = "[\u4e00-\u9fa5]";
		for (int i=0; i<unit.length; i++) {
			try {
				System.out.print(unit[i].getCreature().getName());
				int length = 0;
				for (int p=0; p<unit[i].getCreature().getName().length(); p++) {
					String temp = unit[i].getCreature().getName().substring(p, p + 1);
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
			if(i%this.scale == this.scale - 1) {
				System.out.print("\n");
			}
		}
		System.out.println();
	}
}
