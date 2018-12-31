package CalabashBrothers;

public class Lineup {
	int LineupType;		//阵法类型
	int ScorpionRow;
	int ScorpionCol;	//蝎子位置
	int MinionsNumber;	//小兵数量
	int []MinionsRow;
	int []MinionsCol;	//小兵位置
	Lineup() {}
	public void LineupAccordingToType() {
		switch(LineupType) {
		case 1:	//鹤翼
			ScorpionRow = 7;
			ScorpionCol = 10;
			MinionsNumber = 6;
			MinionsRow = new int[] {4,5,6,6,5,4};
			MinionsCol = new int[] {7,8,9,11,12,13};
			break;
		case 2:	//雁行
			ScorpionRow = 5;
			ScorpionCol = 9;
			MinionsNumber = 4;
			MinionsRow = new int[] {7,6,4,3};
			MinionsCol = new int[] {7,8,10,11};
			break;
		case 3:	//衡轭
			ScorpionRow = 5;
			ScorpionCol = 9;
			MinionsNumber = 6;
			MinionsRow = new int[] {3,7,2,4,6,8};
			MinionsCol = new int[] {9,9,10,10,10,10};
			break;
		case 4:	//长蛇
			ScorpionRow = 6;
			ScorpionCol = 9;
			MinionsNumber = 6;
			MinionsRow = new int[] {2,3,4,5,7,8};
			MinionsCol = new int[] {9,9,9,9,9,9};
			break;
		case 5:	//鱼鳞
			ScorpionRow = 5;
			ScorpionCol = 10;
			MinionsNumber = 9;
			MinionsRow = new int[] {6,5,6,3,7,4,6,5,6};
			MinionsCol = new int[] {7,8,9,10,10,11,11,12,13};
			break;
		case 6: //方円
			ScorpionRow = 5;
			ScorpionCol = 8;
			MinionsNumber = 7;
			MinionsRow = new int[] {4,6,3,7,4,6,5};
			MinionsCol = new int[] {9,9,10,10,11,11,12};
			break;
		case 7: //偃月
			ScorpionRow = 5;
			ScorpionCol = 6;
			MinionsNumber = 18;
			MinionsRow = new int[] {4,6,4,5,6,3,7,2,4,5,6,8,3,7,2,8,1,9};
			MinionsCol = new int[] {6,6,7,7,7,8,8,9,9,9,9,9,10,10,11,11,12,12};
			break;
		case 8:	//锋矢
			ScorpionRow = 4;
			ScorpionCol = 9;
			MinionsNumber = 12;
			MinionsRow = new int[] {5,4,3,2,3,5,6,7,8,3,4,5};
			MinionsCol = new int[] {6,7,8,9,9,9,9,9,9,10,11,12};
			break;
		default://others
			ScorpionRow = 6;
			ScorpionCol = 9;
			MinionsNumber = 1;
			MinionsRow = new int[] {6};
			MinionsCol = new int[] {10};
			break;
		}
	}
}