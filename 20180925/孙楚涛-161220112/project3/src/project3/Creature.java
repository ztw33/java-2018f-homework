package project3;

public class Creature extends ObjPlace{
	int blood;
	
	public void move(int x1,int y1) {
		Main.space.space[x][y] = null;
		Main.space.space[x1][y1] = this;
		
		this.x = x1;
		this.y = y1;
	};
	
	public void show()
	{
		Main.space.space[x][y] = this;
	}
	
	public void dead()
	{
		alive = 0;
	}
	
	public void disappear()
	{
		alive = 0;
	}
}
