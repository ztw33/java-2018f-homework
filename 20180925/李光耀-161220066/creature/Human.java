package creature;

import gui.Gui;
import util.Encourage;


/**
* @ClassName: Human
* @Description: 人类 拥有一个静态成员用于表示老人
* @author 13745
* @date 2018年11月4日
*
*/
public class Human extends GoodCreature implements Encourage{
	
	public static Human grandPa;
	static{
		grandPa=new Human("老爷爷",StyleImage.GRANDPA);		
	}
	
	public Human(String name,StyleImage image) {
		super(name,image);
	}

	@Override
	public void cheerUp() {
		// TODO Auto-generated method stub
		Gui.textArea.append("老爷爷为葫芦娃兄弟加油！\n");
	}

}