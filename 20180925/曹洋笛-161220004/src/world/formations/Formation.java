package world.formations;

import world.creatures.Creature;
import world.tools.*;

/* 阵型抽象类 */

public abstract class Formation {
		
	protected Types type; // 阵型种类
	protected int formRangeRow; // 阵型所占行数
	protected int formRangeCol; // 阵型所占列数
	protected Creature[][] creatureMap; // 阵型图（人物实体）
	
	protected Point formCenter; // 阵型图中心点，用于定位
	protected Point formLeader; // 阵型中领导者所在点
	
	protected Formation(int r, int c) {
		formRangeRow = r;
		formRangeCol = c;
		formCenter = null;
		formLeader = null;
		
		creatureMap = new Creature[formRangeRow][formRangeRow];
		for (int i = 0; i < formRangeRow; i++) {
			for (int j = 0; j < formRangeRow; j++) {
				creatureMap[i][j] = null;  // 初始化全空
			}
		}
	}
	
	public Point center() { // 得到阵型中心坐标
		return formCenter;
	}
	
	public Types getType() { // 得到阵型类型
		return type;
	}
	
	public int getRowNum() { // 得到阵型行数
		return formRangeRow;
	}
	
	public int getColNum() { // 得到阵型列数
		return formRangeCol;
	}
	
	public boolean isEmpty(int r, int c) { // 某处是否有人
		return (creatureMap[r][c] == null);
	}
	
	public char[][] getFormMap() { // 得到阵型显示图
		char[][] form = new char[formRangeRow][formRangeCol];
		for (int i = 0; i < formRangeRow; i++) {
			for (int j = 0; j < formRangeCol; j++) {
				if (creatureMap[i][j] == null)
					form[i][j]= ' '; 
				else
					form[i][j] = creatureMap[i][j].getSymbol();
			}
		}
		return form;
	}
		
	public void showFormation() { // 打印阵型
		for (int i = 0; i < formRangeRow; i++) {
			for (int j = 0; j < formRangeCol; j++) {
				if (creatureMap[i][j] == null)
					System.out.print("  ");
				else
					System.out.print(creatureMap[i][j].getSymbol() + " ");
			}
			System.out.println();
		}
	}
}
