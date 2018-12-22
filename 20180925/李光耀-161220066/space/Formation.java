package space;

import java.util.ArrayList;

import creature.Being;
import gui.Gui;

//向外暴露
/**
* @ClassName: Formation
* @Description: 用于所有基本阵型的抽象基类 不能显示实例化
* @author 13745
* @date 2018年11月4日
*
*/
public abstract class Formation {
	//protected int num;	//所占的方块个数
	protected ArrayList<Square<Being>> formation=new ArrayList<>();
	//protected Square[] formation;
	
	protected static int broadxLines=Gui.N;
	protected static int broadyLines=Gui.N;
	
	public Formation() {
		//this.num=num;
		//formation=new Square[num];
	}
	
	public ArrayList<Square<Being>> getFormation(){
		return formation;
	}
}





