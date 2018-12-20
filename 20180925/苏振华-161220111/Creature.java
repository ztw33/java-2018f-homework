package CalabashBrothers;

enum Rank{First,Second,Third,Fourth,Fifth,Sixth,Seventh}	//枚举葫芦兄弟

public class Creature {			//基类
	protected char CreatureType;//人物类型
	protected int Row;			//行
	protected int Col;			//列
}

class Calabashbrother extends Creature {	//派生类1 葫芦兄弟
	public int Number;						//用于排队
	Calabashbrother(Rank a, int row, int col){
		Row = row;
		Col = col;
		switch(a) {
		case First:
			CreatureType = '1';
			Number = 1;
			break;
		case Second:
			CreatureType = '2';
			Number = 2;
			break;
		case Third:
			CreatureType = '3';
			Number = 3;
			break;
		case Fourth:
			CreatureType = '4';
			Number = 4;
			break;
		case Fifth:
			CreatureType = '5';
			Number = 5;
			break;
		case Sixth:
			CreatureType = '6';
			Number = 6;
			break;
		case Seventh:
			CreatureType = '7';
			Number = 7;
			break;
		default:
			CreatureType = '?';
			Number = 0;
			break;
		}
	}
}

class Grandpa extends Creature {	//派生类2 爷爷
	Grandpa(int row, int col){
		Row = row;
		Col = col;
		CreatureType = 'G';
	}
}

class Minions extends Creature {	//派生类3 小兵
	Minions(int row,int col){
		Row = row;
		Col = col;
		CreatureType = 'M';
	}
}

class SnakeQueen extends Creature {	//派生类4 蛇精
	SnakeQueen(int row,int col){
		Row = row;
		Col = col;
		CreatureType = 'Q';
	}
}

class Scorpion extends Creature {	//派生类5 蝎子精
	Scorpion(int row,int col){
		Row = row;
		Col = col;
		CreatureType = 'S';
	}
}