package creature;


import gui.Gui;
import util.Encourage;


/**
* @ClassName: SnakeEssence
* @Description: 蛇精
* @author 13745
* @date 2018年11月4日
*
*/
public class SnakeEssence extends BadCreature implements Encourage{

	public static SnakeEssence snakeWoman;
	
	static{
		snakeWoman=new SnakeEssence("蛇精",StyleImage.SNAKE);
	}
	
	public SnakeEssence(String name,StyleImage image) {
		super(name,image);
	}

	@Override
	public void cheerUp() {
		// TODO Auto-generated method stub
		Gui.textArea.append("蛇精为蝎子精、众妖怪兄弟加油助威!\n");
	}

}
