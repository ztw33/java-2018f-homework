package java2018.CalabashBrother.main;
import java.util.*;
import java2018.CalabashBrother.BattleField.*;
import java2018.CalabashBrother.Beings.*;
import java2018.CalabashBrother.Randomnum.*;
public class Director {
	
	private BattleFields BFs;
	private CalabashBrothers CBs;
	//private Monsters Ms;
	Director(){
		BFs = null;
		CBs = null;
		//Ms = null;
	}
	Director(BattleFields bfs){
		BFs = bfs;
	}
	
	Director(BattleFields bfs, CalabashBrothers cbs){//, Monsters ms){
		BFs = bfs;
		CBs = cbs;
		//Ms =ms;
	}
	public boolean setFormation(int x, int y, int biasY, Creature t) {
	
		if(BFs.Containable(x, y, 1, 1)) {
			BFs.SetBFPosition(x, y, t);
			return true;
		}
		return false;
	}
	public boolean setFormation(int x, int y, int biasY, String formationName,Vector<Creature>list) {
		
		switch(formationName) {
		case "鹤翼"://坐标为左上
			if(BFs.Containable(x, y, 4, 7)) {
				list.get(0).MoveToPos(x, y);
				BFs.SetBFPosition(x, y, list.get(0));
				list.get(1).MoveToPos(x+1, y+1);
				BFs.SetBFPosition(x + 1, y+1, list.get(1));
				list.get(2).MoveToPos(x+2, y+2);
				BFs.SetBFPosition(x+2, y+2, list.get(2));
				list.get(3).MoveToPos(x+3, y+3);
				BFs.SetBFPosition(x+3, y+3, list.get(3));
				list.get(4).MoveToPos(x+2, y+4);
				BFs.SetBFPosition(x+2, y+4, list.get(4));
				list.get(5).MoveToPos(x+1, y+5);
				BFs.SetBFPosition(x+1, y+5, list.get(5));
				list.get(6).MoveToPos(x, y+6);
				BFs.SetBFPosition(x, y+6, list.get(6));
				return true;
			}
			else return false;
		case "雁行"://坐标为左上
			if(BFs.Containable(x, y, 5, 5)) {
				list.get(0).MoveToPos(x + 4, y);
				BFs.SetBFPosition(x+4, y, list.get(0));
				list.get(1).MoveToPos(x+3, y+1);
				BFs.SetBFPosition(x+3, y+1, list.get(1));
				list.get(2).MoveToPos(x+2, y+2);
				BFs.SetBFPosition(x+2, y+2, list.get(2));
				list.get(3).MoveToPos(x+1, y+3);
				BFs.SetBFPosition(x+1, y+3, list.get(3));
				list.get(4).MoveToPos(x, y+4);
				BFs.SetBFPosition(x, y+4, list.get(4));
				return true;
			}
			else return false;

		case "衡轭"://坐标为左上

			if(BFs.Containable(x, y, 6, 2)) {
				list.get(0).MoveToPos(x, y+1);
				BFs.SetBFPosition(x, y+1, list.get(0));
				list.get(1).MoveToPos(x+1, y);
				BFs.SetBFPosition(x+1, y, list.get(1));
				list.get(2).MoveToPos(x+2, y+1);
				BFs.SetBFPosition(x+2, y+1, list.get(2));
				list.get(3).MoveToPos(x+3, y);
				BFs.SetBFPosition(x+3, y, list.get(3));
				list.get(4).MoveToPos(x+4, y+1);
				BFs.SetBFPosition(x+4, y+1, list.get(4));
				list.get(5).MoveToPos(x+5, y);
				BFs.SetBFPosition(x+5, y, list.get(5));
				return true;
			}
			else return false;

		case "长蛇"://坐标为上
			if(BFs.Containable(x, y, 6, 1)) {
				list.get(0).MoveToPos(x, y);
				BFs.SetBFPosition(x, y, list.get(0));
				list.get(1).MoveToPos(x+1, y);
				BFs.SetBFPosition(x+1, y, list.get(1));
				list.get(2).MoveToPos(x+2, y);
				BFs.SetBFPosition(x+2, y, list.get(2));
				list.get(3).MoveToPos(x+3, y);
				BFs.SetBFPosition(x+3, y, list.get(3));
				list.get(4).MoveToPos(x+4, y);
				BFs.SetBFPosition(x+4, y, list.get(4));
				list.get(5).MoveToPos(x+5, y);
				BFs.SetBFPosition(x+5, y, list.get(5));
				return true;
			}
			else return false;

		case "鱼鳞"://左上
			if(BFs.Containable(x, y, 5, 5)) {
				list.get(0).MoveToPos(x, y+2);
				BFs.SetBFPosition(x, y+2, list.get(0));
				list.get(1).MoveToPos(x+1, y+3);
				BFs.SetBFPosition(x+1, y+3, list.get(1));
				list.get(2).MoveToPos(x+2, y+1);
				BFs.SetBFPosition(x+2, y+1, list.get(2));
				list.get(3).MoveToPos(x+2, y+2);
				BFs.SetBFPosition(x+2, y+2, list.get(3));
				list.get(4).MoveToPos(x+2, y+3);
				BFs.SetBFPosition(x+2, y+3, list.get(4));
				list.get(5).MoveToPos(x+3, y);
				BFs.SetBFPosition(x+3, y, list.get(5));
				list.get(6).MoveToPos(x+3, y+1);
				BFs.SetBFPosition(x+3, y+1, list.get(6));
				list.get(7).MoveToPos(x+3, y+3);
				BFs.SetBFPosition(x+3, y+3, list.get(7));
				list.get(8).MoveToPos(x+3, y+4);
				BFs.SetBFPosition(x+3, y+4, list.get(8));
				list.get(9).MoveToPos(x+4, y+2);
				BFs.SetBFPosition(x+4, y+2, list.get(9));
				return true;
			}
			else return false;

		case "方门"://坐标同上
			if(BFs.Containable(x, y, 5, 5)) {
				list.get(0).MoveToPos(x, y+2);
				BFs.SetBFPosition(x, y+2, list.get(0));
				list.get(1).MoveToPos(x+1, y+1);
				BFs.SetBFPosition(x+1, y+1, list.get(1));
				list.get(2).MoveToPos(x+1, y+3);
				BFs.SetBFPosition(x+1, y+3, list.get(2));
				list.get(3).MoveToPos(x+2, y);
				BFs.SetBFPosition(x+2, y, list.get(3));
				list.get(4).MoveToPos(x+2, y+4);
				BFs.SetBFPosition(x+2, y+4, list.get(4));
				list.get(5).MoveToPos(x+3, y+1);
				BFs.SetBFPosition(x+3, y+1, list.get(5));
				list.get(6).MoveToPos(x+3, y+3);
				BFs.SetBFPosition(x+3, y+3, list.get(6));
				list.get(7).MoveToPos(x+4, y+2);
				BFs.SetBFPosition(x+4, y+2, list.get(7));
				return true;
			}
			else return false;

		case "偃月"://同上
			
			if(BFs.Containable(x, y, 9, 5)) {
				list.get(0).MoveToPos(x+3, y);
				BFs.SetBFPosition(x+3, y, list.get(0));
				list.get(1).MoveToPos(x+4, y);
				BFs.SetBFPosition(x+4, y, list.get(1));
				list.get(2).MoveToPos(x+5, y);
				BFs.SetBFPosition(x+5, y, list.get(2));
				list.get(3).MoveToPos(x+3, y+1);
				BFs.SetBFPosition(x+3, y+1, list.get(3));
				list.get(4).MoveToPos(x+4, y+1);
				BFs.SetBFPosition(x+4, y+1, list.get(4));
				list.get(5).MoveToPos(x+5, y+1);
				BFs.SetBFPosition(x+5, y+1, list.get(5));
				list.get(6).MoveToPos(x+1, y+2);
				BFs.SetBFPosition(x+1, y+2, list.get(6));
				list.get(7).MoveToPos(x+2, y+2);
				BFs.SetBFPosition(x+2, y+2, list.get(7));
				list.get(8).MoveToPos(x+3, y+2);
				BFs.SetBFPosition(x+3, y+2, list.get(8));
				list.get(9).MoveToPos(x+4, y+2);
				BFs.SetBFPosition(x+4, y+2, list.get(9));
				list.get(10).MoveToPos(x+5, y+2);
				BFs.SetBFPosition(x+5, y+2, list.get(10));
				list.get(11).MoveToPos(x+6, y+2);
				BFs.SetBFPosition(x+6, y+2, list.get(11));
				list.get(12).MoveToPos(x+7, y+2);
				BFs.SetBFPosition(x+7, y+2, list.get(12));
				list.get(13).MoveToPos(x+1, y+3);
				BFs.SetBFPosition(x+1, y+3, list.get(13));
				list.get(14).MoveToPos(x+2, y+3);
				BFs.SetBFPosition(x+2, y+3, list.get(14));
				list.get(15).MoveToPos(x+6, y+3);
				BFs.SetBFPosition(x+6, y+3, list.get(15));
				list.get(16).MoveToPos(x+7, y+3);
				BFs.SetBFPosition(x+7, y+3, list.get(16));
				list.get(17).MoveToPos(x, y+4);
				BFs.SetBFPosition(x, y+4, list.get(17));
				list.get(18).MoveToPos(x+8, y+4);
				BFs.SetBFPosition(x+8, y+4, list.get(18));
				return true;
			}
			else return false;

		case "锋矢":
			if(BFs.Containable(x, y, 6, 5)) {
				list.get(0).MoveToPos(x, y+1);
				BFs.SetBFPosition(x, y+1, list.get(0));
				list.get(1).MoveToPos(x, y+2);
				BFs.SetBFPosition(x, y+2, list.get(1));
				list.get(2).MoveToPos(x, y+3);
				BFs.SetBFPosition(x, y+3, list.get(2));
				list.get(3).MoveToPos(x+1, y);
				BFs.SetBFPosition(x+1, y, list.get(3));
				list.get(4).MoveToPos(x+1, y+2);
				BFs.SetBFPosition(x+1, y+2, list.get(4));
				list.get(5).MoveToPos(x+1, y+4);
				BFs.SetBFPosition(x+1, y+4, list.get(5));
				list.get(6).MoveToPos(x+2, y);
				BFs.SetBFPosition(x+2, y, list.get(6));
				list.get(7).MoveToPos(x+2, y+2);
				BFs.SetBFPosition(x+2, y+2, list.get(7));
				list.get(8).MoveToPos(x+2, y+4);
				BFs.SetBFPosition(x+2, y+4, list.get(8));
				list.get(9).MoveToPos(x+3, y+2);
				BFs.SetBFPosition(x+3, y+2, list.get(9));
				list.get(10).MoveToPos(x+4, y+2);
				BFs.SetBFPosition(x+4, y+2, list.get(10));
				list.get(11).MoveToPos(x+5, y+2);
				BFs.SetBFPosition(x+5, y+2, list.get(11));
				return true;
			}
			else return false;

		default://随机选择一个能够容纳下的
			return false;

		}
	}
	
	//输出名字状态
	public void QueueNameStatus() {
		CBs.QueueNameStatus();
	}
	
	public void QueueNameStatus(CalabashBrothers calabashbrothers) {
		calabashbrothers.QueueNameStatus();
	}
	
	//输出颜色状态
	public void QueueColorStatus() {
		CBs.QueueColorStatus();
	}
	public void QueueColorStatus(CalabashBrothers calabashbrothers) {
		calabashbrothers.QueueColorStatus();
	}
	
	//冒泡排序
	public void BubbleSort() {
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6 - i; j++) {
				if(CBs.getBrother(j).compareTo(CBs.getBrother(j + 1))>0) {
					
					CBs.SwapBrother(j, j + 1);
					
				}
			}
		}
	}
	public static void BubbleSort(CalabashBrothers calabashbrothers) {
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6 - i; j++) {
				if(calabashbrothers.getBrother(j).compareTo(calabashbrothers.getBrother(j + 1))>0) {
					
					calabashbrothers.SwapBrother(j, j + 1);
					
				}
			}
		}
	}
	
	//快速排序
	private int Partition(int p, int r){
		CalabashBrother pivot= CBs.getBrother(r);
		int i = p - 1;
		for(int j = p; j < r;j++){
			if(CBs.getBrother(j).compareTo(pivot) < 0){
				i++;
				CBs.SwapBrother(i, j);
			}
		}
		CBs.SwapBrother(r, i + 1);
		//elements[r] = elements[i + 1]
		//elements[i + 1] = pivot;
		return i + 1;
	}
	public void QuickSort(int p, int r) {
		if(p < r) {
			int q = Partition(p, r);
			QuickSort(CBs, p, q - 1);
			QuickSort(CBs, q + 1, r);
		}
	}
	
	private static int Partition(CalabashBrothers calabashbrothers, int p, int r){//静态方法无需实例化
		CalabashBrother pivot= calabashbrothers.getBrother(r);
		int i = p - 1;
		for(int j = p; j < r;j++){
			if(calabashbrothers.getBrother(j).compareTo(pivot) < 0){
				i++;
				calabashbrothers.SwapBrother(i, j);
			}
		}
		calabashbrothers.SwapBrother(r, i + 1);
		//elements[r] = elements[i + 1]
		//elements[i + 1] = pivot;
		return i + 1;
	}
	public static void QuickSort(CalabashBrothers calabashbrothers, int p, int r) {//静态方法无需实例化
		if(p < r) {
			int q = Partition(calabashbrothers, p, r);
			QuickSort(calabashbrothers, p, q - 1);
			QuickSort(calabashbrothers, q + 1, r);
		}
	}
	
	public void Disorder() {
		CBs.Disorder();
	}
	public CalabashBrother getBrother(int index) {
		return CBs.getBrother(index);
	}
	public void showBF() {
		BFs.BFOutput();
	}
	public void clearBattleField() {
		BFs.initializeBattleField();
	}
	public static void main(String[] args) {
		//BattleFields battlefields = new BattleFields();
		Director director = new Director(new BattleFields(),new CalabashBrothers());//, new Monsters());
		
		//作业2
		//CalabashBrothers calabashbrothers = new CalabashBrothers();
		//calabashbrothers.QueueNameStatus();
		//calabashbrothers.QueueColorStatus();
		/*
		System.out.println("作业二");
		director.QueueNameStatus();
		director.QueueColorStatus();
		
		director.BubbleSort();
		director.QueueNameStatus();
		director.QueueColorStatus();
		
		director.Disorder();
		director.QueueNameStatus();
		director.QueueColorStatus();
		
		director.QuickSort(0, 6);
		director.QueueNameStatus();
		director.QueueColorStatus();
		*/
		
		//作业三
		//葫芦娃以长蛇阵放在阵地中
		while(true) {
			director.clearBattleField();
		int x0,y0;
		Vector<Creature>CBList = new Vector<Creature>();
		CBList.add(director.getBrother(0));
		CBList.add(director.getBrother(1));
		CBList.add(director.getBrother(2));
		CBList.add(director.getBrother(3));
		CBList.add(director.getBrother(4));
		CBList.add(director.getBrother(5));
		CBList.add(director.getBrother(6));
		do {
			x0 = Randomnum.getRandom(10);
			y0 =Randomnum.getRandom(10);
			director.QuickSort(0, 6);
			System.out.println(CBList.size());
		}while(!director.setFormation(x0, y0, 0, "长蛇", CBList));
			
		//放置爷爷	
		GrandPa g = new GrandPa();
		do {
			x0 = Randomnum.getRandom(10);
			y0 =Randomnum.getRandom(10);
		}while(!director.setFormation(x0, y0, 0, g));
		
		
		
		//放置蝎子精和小喽啰
		int x1,y1;
		int formation = Randomnum.getRandom(7);//生成随机数选择阵型
		String formationName = null;
		Vector<Creature>MonsterList = new Vector<Creature>();
		do {
			MonsterList.clear();
			x1 = Randomnum.getRandom(10);
			y1 =Randomnum.getRandom(10) + 10;
			switch(formation) {
			
			case 0:
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
			
				MonsterList.add(new Scorpion());
			
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				formationName = new String("鹤翼");
				//director.setFormation(x1, y1, "鹤翼", MonsterList);
				break;
			
			case 1:
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
			
				MonsterList.add(new Scorpion());
			
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				formationName = new String("雁行");
				//director.setFormation(x1, y1, "雁行", MonsterList);
				break;
			case 2:
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
			
				MonsterList.add(new Scorpion());
			
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				formationName = new String("衡轭");
				//director.setFormation(x1, y1, "衡轭", MonsterList);
				break;
		/*case 3:
			MonsterList.add(new LouLuo());
			MonsterList.add(new LouLuo());
			
			MonsterList.add(new Scorpion());
			
			MonsterList.add(new LouLuo());
			MonsterList.add(new LouLuo());
			MonsterList.add(new LouLuo());
			director.setFormation(x1, y1, "长蛇", MonsterList);
			break;
		*/
			case 3:
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());	
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new Scorpion());
				formationName = new String("鱼鳞");
				//director.setFormation(x1, y1, "鱼鳞", MonsterList);
				break;
			case 4:
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new Scorpion());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				formationName = new String("方门");
				//director.setFormation(x1, y1, "方门", MonsterList);
				break;
			case 5:
				MonsterList.add(new LouLuo());
				MonsterList.add(new Scorpion());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				formationName = new String("偃月");
				//director.setFormation(x1, y1, "偃月", MonsterList);
				break;
			case 6:
				MonsterList.add(new LouLuo());
				MonsterList.add(new Scorpion());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				MonsterList.add(new LouLuo());
				formationName = new String("锋矢");
				//director.setFormation(x1, y1, "锋矢", MonsterList);
				break;
			
		}
			System.out.println("x1"+x1+"y1"+y1);
		}while(!director.setFormation(x1, y1, 10, formationName, MonsterList));
		//放置蛇精
		Snake S = new Snake();
		do {
			x1 = Randomnum.getRandom(10);
			y1 =Randomnum.getRandom(10)+10;
		}while(!director.setFormation(x1, y1, 10, S));
		System.out.println(x1+" "+y1);
		director.showBF();
		try{Thread.sleep(100);
		}catch(InterruptedException e) {
		}
		}

		
	}
	
}
