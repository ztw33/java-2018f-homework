package javahw3;

import java.util.ArrayList;

public class Formation{
	/*
	 * 阵型类，保存双方的阵型信息
	 * Variables: ArrayList<int[][]> book1, ArrayList<int[][]> book1;
	 * Methods: initialization(), getForm(), convert();
	 * */
	private static ArrayList<int[][]> book1;
	private static ArrayList<int[][]> book2;
	
	public static void initialization() {
		book1 = new ArrayList<int[][]>();
		book2 = new ArrayList<int[][]>();
		int x1[][] = {{4,4},{5,4},{6,4},{7,4},{8,4},{9,4},{10,4},{7,2}} ;
		int x2[][] = {{4,6},{5,5},{6,4},{7,3},{8,2},{9,1},{10,0},{5,1}} ;
		int x3[][] = {{4,6},{5,5},{6,4},{7,3},{6,2},{5,1},{4,0},{4,3}} ;
		int x4[][] = {{3,3},{4,4},{5,3},{6,4},{7,3},{8,4},{9,3},{6,1}} ;
		
		book1.add(x1);
		book2.add(convert(x1));
		book1.add(x2);
		book2.add(convert(x2));
		book1.add(x3);
		book2.add(convert(x3));
		book1.add(x4);
		book2.add(convert(x4));
	}
	
	public static int[][] getForm(int m, int team){
		if (team == 1)
			return book1.get(m);
		else
			return book2.get(m);
	}
	private static int[][] convert(int[][] xx){
		int[][] y = new int[8][2];
		for (int i=0; i<7; i++) {
			y[i][1] = 14 - xx[i][1];
			y[i][0] = xx[i][0];
		}
		y[7][1] = 14 - xx[7][1];
		y[7][0] = xx[7][0];
		return y;
	}
	
}