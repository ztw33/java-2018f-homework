package calabashbrothers;

//enum identy{calabash,grandpa,snake,scorpion,minion}
enum brother{red,orange,yellow,green,cyan,blue,purple}

public class Creature {
	String name;
	char symbol;
	int loc_x;
	int loc_y;
}

class calabash extends Creature{
	//enum brother{red,orange,yellow,green,cyan,blue,purple};
	//brother e;
	calabash(brother e){
		switch(e) {
		case red:
			name="老大";
			symbol='1';
			break;
		case orange:
			name="老二";
			symbol='2';
			break;
		case yellow:
			name="老三";
			symbol='3';
			break;
		case green:
			name="老四";
			symbol='4';
			break;
		case cyan:
			name="老五";
			symbol='5';
			break;
		case blue:
			name="老六";
			symbol='6';
			break;
		case purple:
			name="老七";
			symbol='7';
			break;
		default:
			break;
			}
	}
	void getposition(int a,int b) {
		loc_x=a;
		loc_y=b;
	}
}

class grandpa extends Creature{
	grandpa(){
		name="爷爷";
		symbol='G';
	}
	void getposition(int a,int b) {
		loc_x=a;
		loc_y=b;
	}
}

class snake extends Creature{
	snake(){
		name="蛇精";
		symbol='S';
	}
	void getposition(int a,int b) {
		loc_x=a;
		loc_y=b;
	}
}

class scorpion extends Creature{
	scorpion(){
		name="蝎子精";
		symbol='C';
	}
	void getposition(int a,int b) {
		loc_x=a;
		loc_y=b;
	}
}

class minion extends Creature{
	minion(){
		name="喽啰";
		symbol='M';
	}
	void getposition(int a,int b) {
		loc_x=a;
		loc_y=b;
	}
}