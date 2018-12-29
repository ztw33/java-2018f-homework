package home3;

public class Space {
	private boolean empty;//判断是否有生物
	private int posx,posy;
	private Creature creature;
	
	public Space() {
		posx = posy = -1;
		empty = true;
		creature = null;
	}
	
	public Space(int x,int y) {
		posx= x;
		posy = y;
		empty = true;
		creature = null;
	}
	
	public Creature getcreature() {
		return creature;
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public void setCreature(Creature a) {
		if(empty) {//如果该位置为空
			creature = a;
			creature.setx(posx);
			creature.sety(posy);
			empty = false;
		}
		else
			System.out.println("该位置已被占据");
	}
	
	public void removeCreature() {
		if(!empty) {
			//creature.setx(-1);
			//creature.sety(-1);
			creature = null;
			empty = true;
		}
		else
			System.out.println("该位置已空");
	}
}
