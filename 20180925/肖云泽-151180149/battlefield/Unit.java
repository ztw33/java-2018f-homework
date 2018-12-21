package battlefield;

import creatures.*;
import formation.*;
public class Unit {
	private Position position;
	private Creature creature;
	private Queue q;
	public Unit() {
		this.position = null;
		this.creature = null;
		this.q = null;
	}
	public Unit(Position p) {
		this.position = p;
	}
	public Position getPosition() {
		return this.position;
	}
	public Creature getCreature() {
		return this.creature;
	}
	public Queue getQ() {
		return this.q;
	}
	public void setQ(Queue q) {
		this.q = q;
	}
	public void setCreature(Creature c) {
		this.creature = c;
	}
}
