import java.lang.*;
import BattleField.*;
import Beings.*;
public class Director {
	
	private BattleFields BFs;
	private CalabashBrothers CBs;
	private Monsters Ms;
	Director(){
		BFs = null;
		CBs = null;
		Ms = null;
	}
	Director(BattleFields bfs){
		BFs = bfs;
	}
	
	Director(BattleFields bfs, CalabashBrothers cbs, Monsters ms){
		BFs = bfs;
		CBs = cbs;
		Ms =ms;
	}
	
	
	//列阵
	public boolean SetFormation(int direction/*队列的朝向*/, int x, int y, String FormationName) {
		switch(FormationName) {
		case "鹤翼"://坐标为左上
			break;
		case "雁行"://坐标为左下
			break;
		case "衡轭"://坐标为左上
			break;
		case "长蛇"://坐标为上
			break;
		case "鱼鳞"://坐标为能包含鱼鳞的最小矩形左上
			break;
		case "方门"://坐标同上，图案由于人数不够，缺最下角
			break;
		case "偃月"://同上
			break;
		case "锋矢":
			break;
		default:
				break;
		}
		return false;
	}
	
	
	//列阵
	public boolean SetFormations(BattleFields BF, int x, int y, String FormationName, CalabashBrothers CBs) {
		//目前为葫芦娃的站位，后期改为根据输入人数调整站位
		switch(FormationName) {
		case "鹤翼"://坐标为左上
			if(BF.Containable(x, y, 7, 4)) {
				CBs.SetCBPostion(0, x, y);
				CBs.SetCBPostion(1, x + 1, y + 1);
				CBs.SetCBPostion(2, x + 2, y + 2);
				CBs.SetCBPostion(3, x + 3, y + 3);
				CBs.SetCBPostion(4, x + 4, y + 2);
				CBs.SetCBPostion(5, x + 5, y + 1);
				CBs.SetCBPostion(6, x + 6, y);
				return true;
			}
			else return false;
		case "雁行"://坐标为左下
			if(BF.Containable(x, y, 7, -7)) {
				CBs.SetCBPostion(0, x, y + 6);
				CBs.SetCBPostion(1, x + 1, y + 5);
				CBs.SetCBPostion(2, x + 2, y + 4);
				CBs.SetCBPostion(3, x + 3, y + 3);
				CBs.SetCBPostion(4, x + 4, y + 2);
				CBs.SetCBPostion(5, x + 5, y + 1);
				CBs.SetCBPostion(6, x + 6, y);
				return true;
			}
			else return false;

		case "衡轭"://坐标为左上
			if(BF.Containable(x, y, 2, 7)) {
				CBs.SetCBPostion(0, x, y);
				CBs.SetCBPostion(1, x + 1, y + 1);
				CBs.SetCBPostion(2, x, y + 2);
				CBs.SetCBPostion(3, x + 1, y + 3);
				CBs.SetCBPostion(4, x, y + 4);
				CBs.SetCBPostion(5, x + 1, y + 5);
				CBs.SetCBPostion(6, x, y + 6);
				return true;
			}
			else return false;

		case "长蛇"://坐标为上
			if(BF.Containable(x, y, 1, 7)) {
				CBs.SetCBPostion(0, x, y);
				CBs.SetCBPostion(1, x, y + 1);
				CBs.SetCBPostion(2, x, y + 2);
				CBs.SetCBPostion(3, x, y + 3);
				CBs.SetCBPostion(4, x, y + 4);
				CBs.SetCBPostion(5, x, y + 5);
				CBs.SetCBPostion(6, x, y + 6);
				return true;
			}
			else return false;

		case "鱼鳞"://坐标为能包含鱼鳞的最小矩形左上
			if(BF.Containable(x, y, 5, 4)) {
				CBs.SetCBPostion(0, x + 2, y);
				CBs.SetCBPostion(1, x + 1, y + 1);
				CBs.SetCBPostion(2, x + 3, y + 1);
				CBs.SetCBPostion(3, x, y + 2);
				CBs.SetCBPostion(4, x + 2, y + 2);
				CBs.SetCBPostion(5, x + 4, y + 2);
				CBs.SetCBPostion(6, x + 2, y + 3);
				return true;
			}
			else return false;

		case "方门"://坐标同上，图案由于人数不够，缺最下角
			if(BF.Containable(x, y, 5, 4)) {
				CBs.SetCBPostion(0, x + 2, y);
				CBs.SetCBPostion(1, x + 1, y + 1);
				CBs.SetCBPostion(2, x + 3, y + 1);
				CBs.SetCBPostion(3, x, y + 2);
				CBs.SetCBPostion(4, x + 4, y + 2);
				CBs.SetCBPostion(5, x + 1, y + 3);
				CBs.SetCBPostion(6, x + 3, y + 3);
				return true;
			}
			else return false;

		case "偃月"://同上
			if(BF.Containable(x, y, 3, 7)) {
				CBs.SetCBPostion(0, x + 2, y);
				CBs.SetCBPostion(1, x + 1, y + 1);
				CBs.SetCBPostion(2, x, y + 2);
				CBs.SetCBPostion(3, x, y + 3);
				CBs.SetCBPostion(4, x, y + 4);
				CBs.SetCBPostion(5, x + 1, y + 5);
				CBs.SetCBPostion(6, x + 2, y + 6);
				return true;
			}
			else return false;

		case "锋矢":
			if(BF.Containable(x, y, 7, 4)) {
				CBs.SetCBPostion(0, x + 2, y);
				CBs.SetCBPostion(1, x + 1, y + 1);
				CBs.SetCBPostion(2, x, y + 2);
				CBs.SetCBPostion(3, x, y + 3);
				CBs.SetCBPostion(4, x, y + 4);
				CBs.SetCBPostion(5, x + 1, y + 5);
				CBs.SetCBPostion(6, x + 2, y + 6);
				return true;
			}
			else return false;

		default://随机选择一个能够容纳下的
			if(BF.Containable(x, y, 7, 4)) {
				
				return true;
			}
			else return false;

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
	public static void main(String[] args) {
		//BattleFields battlefields = new BattleFields();
		Director director = new Director(new BattleFields(),new CalabashBrothers(), new Monsters());
		
		//CalabashBrothers calabashbrothers = new CalabashBrothers();
		//calabashbrothers.QueueNameStatus();
		//calabashbrothers.QueueColorStatus();
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
		
		/*
		director.BubbleSort(calabashbrothers);
		calabashbrothers.QueueNameStatus();
		calabashbrothers.QueueColorStatus();
		
		calabashbrothers.Disorder();
		calabashbrothers.QueueNameStatus();
		calabashbrothers.QueueColorStatus();
		
		director.QuickSort(calabashbrothers, 0, 6);
		calabashbrothers.QueueNameStatus();
		calabashbrothers.QueueColorStatus();
		*/
	}
	
}
