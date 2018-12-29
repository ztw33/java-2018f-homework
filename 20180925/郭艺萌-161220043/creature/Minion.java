package creature;

public class Minion extends Creature{
	public Minion(int no) {
		super.name = "小喽啰" + no;
	}
	public String getName() {
		return this.name;
	}
}
