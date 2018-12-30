package formation;

import creature.*;
import map.*;

public abstract class Formation {
	protected String name;
	//输入生物 队首坐标
	public abstract void form(Map map, Creature[] creatures, int x, int y); //形成队形
	public abstract void loose(Map map, Creature[] creatures, int x, int y);//解散队形
}
