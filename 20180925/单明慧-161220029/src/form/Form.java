package form;

import java.util.ArrayList;

import javax.swing.JTextArea;

import creature.*;
import sort.Sort;

public class Form {
	public CalabashBrothers calabashBro;
	public Grandpa oneGrandpa;
	public ArrayList<Underlyings> severalUnderlying = new ArrayList<Underlyings>();
	public Snake oneSnake;
	public Scorpion oneScorpion;
	int lastFormation;//阵型要和上次不一样
	public Form(){
		calabashBro = new CalabashBrothers();
		oneGrandpa = new Grandpa();
		//System.out.println("葫芦兄弟开始排队……");
		Sort sortCalabash = new Sort(calabashBro.sevenBro);
		sortCalabash.sortByNo();//按照姓名排队
		oneSnake = new Snake();
		oneScorpion = new Scorpion();
	}
	public void formForGood(){
		calabashBro.sevenBro[0].setPos(3, 4);
		calabashBro.sevenBro[1].setPos(4, 4);
		calabashBro.sevenBro[2].setPos(5, 4);
		calabashBro.sevenBro[3].setPos(6, 4);
		calabashBro.sevenBro[4].setPos(7, 4);
		calabashBro.sevenBro[5].setPos(8, 4);
		calabashBro.sevenBro[6].setPos(9, 4);
		oneGrandpa.setPos(6, 2);
	}
	//反派要变换的阵型
	int HE_YI() {
		oneScorpion.setPos(6, 8);
		severalUnderlying.clear();
		for(int i = 0 ;i < 6; i++)
		{
			severalUnderlying.add(new Underlyings());
		}
		severalUnderlying.get(0).setPos(7, 9);
		severalUnderlying.get(1).setPos(8, 10);
		severalUnderlying.get(2).setPos(9, 11);
		severalUnderlying.get(3).setPos(8, 12);
		severalUnderlying.get(4).setPos(7, 13);
		severalUnderlying.get(5).setPos(6, 14);
		oneSnake.setPos(7, 11);
		return 6;
	}
	int YAN_XING() {
		oneScorpion.setPos(7, 9);
		severalUnderlying.clear();
		for(int i = 0 ;i < 4; i++)
		{
			severalUnderlying.add(new Underlyings());
		}
		severalUnderlying.get(0).setPos(6, 10);
		severalUnderlying.get(1).setPos(5, 11);
		severalUnderlying.get(2).setPos(4, 12);
		severalUnderlying.get(3).setPos(3, 13);
		oneSnake.setPos(6, 12);
		return 4;
	}
	int HENG_E() {
		oneScorpion.setPos(6, 8);
		severalUnderlying.clear();
		for(int i = 0 ;i < 5; i++)
		{
			severalUnderlying.add(new Underlyings());
		}
		severalUnderlying.get(0).setPos(7, 8);
		severalUnderlying.get(1).setPos(8, 8);
		severalUnderlying.get(2).setPos(5, 9);
		severalUnderlying.get(3).setPos(6, 9);
		severalUnderlying.get(4).setPos(7, 9);
		oneSnake.setPos(6, 11);
		return 5;
	}
	int YU_LIN() {
		oneScorpion.setPos(6, 9);
		severalUnderlying.clear();
		for(int i = 0 ;i < 9; i++)
		{
			severalUnderlying.add(new Underlyings());
		}
		severalUnderlying.get(0).setPos(6, 10);
		severalUnderlying.get(1).setPos(6, 11);
		severalUnderlying.get(2).setPos(6, 12);
		severalUnderlying.get(3).setPos(7, 11);
		severalUnderlying.get(4).setPos(5, 9);
		severalUnderlying.get(5).setPos(5, 10);
		severalUnderlying.get(6).setPos(5, 11);
		severalUnderlying.get(7).setPos(4, 10);
		severalUnderlying.get(8).setPos(3, 9);
		oneSnake.setPos(6, 13);
		return 9;
	}
	int FANG_YUAN() {
		oneScorpion.setPos(6, 8);
		severalUnderlying.clear();
		for(int i = 0 ;i < 7; i++)
		{
			severalUnderlying.add(new Underlyings());
		}
		severalUnderlying.get(0).setPos(7, 9);
		severalUnderlying.get(1).setPos(5, 9);
		severalUnderlying.get(2).setPos(4, 10);
		severalUnderlying.get(3).setPos(8, 10);
		severalUnderlying.get(4).setPos(5, 11);
		severalUnderlying.get(5).setPos(7, 11);
		severalUnderlying.get(6).setPos(6, 12);
		oneSnake.setPos(6, 10);
		return 7;
	}
	int YAN_YUE(){
		oneScorpion.setPos(6, 8);
		severalUnderlying.clear();
		for(int i = 0 ;i < 18; i++)
		{
			severalUnderlying.add(new Underlyings());
		}
		severalUnderlying.get(0).setPos(5, 8);
		severalUnderlying.get(1).setPos(7, 8);
		severalUnderlying.get(2).setPos(5, 9);
		severalUnderlying.get(3).setPos(6, 9);
		severalUnderlying.get(4).setPos(7, 9);
		severalUnderlying.get(5).setPos(4, 10);
		severalUnderlying.get(6).setPos(3, 11);
		severalUnderlying.get(7).setPos(8, 10);
		severalUnderlying.get(8).setPos(9, 11);
		severalUnderlying.get(9).setPos(5, 10);
		severalUnderlying.get(10).setPos(6, 10);
		severalUnderlying.get(11).setPos(7, 10);
		severalUnderlying.get(12).setPos(4, 11);
		severalUnderlying.get(13).setPos(3, 12);
		severalUnderlying.get(14).setPos(2, 13);
		severalUnderlying.get(15).setPos(8, 11);
		severalUnderlying.get(16).setPos(9, 12);
		severalUnderlying.get(17).setPos(10, 13);
		oneSnake.setPos(6, 11);
		return 18;
	}
	int FENG_SHI() {
		oneScorpion.setPos(3, 11);
		severalUnderlying.clear();
		for(int i = 0 ;i < 11; i++)
		{
			severalUnderlying.add(new Underlyings());
		}
		severalUnderlying.get(0).setPos(6, 8);
		severalUnderlying.get(1).setPos(5, 9);
		severalUnderlying.get(2).setPos(4, 10);
		severalUnderlying.get(3).setPos(4, 11);
		severalUnderlying.get(4).setPos(4, 12);
		severalUnderlying.get(5).setPos(5, 13);
		severalUnderlying.get(6).setPos(6, 14);
		severalUnderlying.get(7).setPos(5, 11);
		severalUnderlying.get(8).setPos(6, 11);
		severalUnderlying.get(9).setPos(7, 11);
		severalUnderlying.get(10).setPos(8, 11);
		oneSnake.setPos(6, 12);
		return 11;
	}
	public int formForBad(JTextArea text) {
		int rand = (int)(1 + Math.random() * ( 7 - 1 + 1));
		while(rand == lastFormation) {
			rand = (int)(1 + Math.random() * ( 7 - 1 + 1));
		}
		lastFormation = rand;
		switch(rand) {
		case 1:
			text.append("蝎子精：鹤翼阵！\n");
			return HE_YI();
		case 2:
			text.append("蝎子精：雁行阵！\n");
			return YAN_XING();
		case 3:
			text.append("蝎子精：衡轭阵！\n");
			return HENG_E();
		case 4:
			text.append("蝎子精：鱼鳞阵！\n");
			return YU_LIN();
		case 5:
			text.append("蝎子精：方圆阵！\n");
			return FANG_YUAN();
		case 6:
			text.append("蝎子精：偃月阵！\n");
			return YAN_YUE();
		case 7:
			text.append("蝎子精：锋矢阵！\n");
			return FENG_SHI();
		default:
			return -1;
		}
	}
}
