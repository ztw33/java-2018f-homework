package BattleField;
import java.util.*;
import Beings.*;
public class BattleFields {//战场为M*N的矩形
	//version 1.0
	/*
	private int M;//战场的长
	private int N;//战场的宽
	private boolean BFStatus[][];
	//private T battleField[][];
	BattleField(){
		M = 100;
		N = 50;
		BFStatus = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				BFStatus[i][j]=false;
			}
		}
		//for(T[] t:battleField) {
		//	for(T tt:t) {
		//		tt = null;
		//	}
		//}

	}
	BattleField(int m, int n){

		M = m;
		N = n;
		BFStatus = new boolean[M][N];

		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				BFStatus[i][j]=false;
			}
		}

	}
	public boolean Containable(int x, int y, int SizeX, int SizeY) {
		if(((x + SizeX) <= M) && ((y + SizeY) <= N) && ((x + SizeX) >=0 ) && ((y + SizeY) >=0))return true;
		else return false;
	}
	public boolean SetBFPosition(int x, int y, CalabashBrother calabashbrother) {
		if(BFStatus[x][y])return false;
		else {
			BFStatus[x][y] = true;
			return true;
		}
		
	}
	*/
	private int M;//战场的长
	private int N;//战场的宽

	private  BattleField BFs[][];//????
	private ArrayList<BattleField<? extends Beings>> BF = new ArrayList<>();
	//private T battleField[][];
	public BattleFields(){
		M = 100;
		N = 50;
		//BFs = new BattleField[M][N];

	}
	BattleFields(int m, int n){

		M = m;
		N = n;
		//BFs = new BattleField[M][N];


	}
	public boolean Containable(int x, int y, int SizeX, int SizeY) {
		if(((x + SizeX) <= M) && ((y + SizeY) <= N) && ((x + SizeX) >=0 ) && ((y + SizeY) >=0))return true;
		else return false;
	}
	public boolean SetBFPosition(int x, int y, BattleField<? extends Beings> t) {
		if(!BFs[x][y].isEmpty())return false;
		else {
			return BFs[x][y].setBeing(t.getBeing());
		}
		
	}

}