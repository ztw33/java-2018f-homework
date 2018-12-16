package creatures;

public class Creature {
	protected String name;
	protected int camp;
	public Creature(){
		this.name = "null";
		this.camp = 0;
	}
	public Creature(String name, int camp){
		this.name = name;
		this.camp = camp;
	}
	public String getName() {
		return this.name;
	}
	public int getCamp() {
		return this.camp;
	}
}
