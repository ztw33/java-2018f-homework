class Creature{
	public Creature(char name) {
		this.name=name;
	}
	public int[] getPosition() {
		int[] ret=new int[2];
		ret[0]=x;
		ret[1]=y;
		return ret;
	}
	public void move(BattleField field,int x,int y) {
		if(this.x>=0&&this.x<field.getSize()&&this.y>=0&&this.y<field.getSize()) 
			field.removeObject(this);
		field.addObject(this, x, y);
		this.x=x;
		this.y=y;
	}
	public char getName() {
		return name;
	}
	private int x=-1,y=-1;
	private char name;
}

class Troop{
	protected Creature[] soldiers;
	protected Creature audience;
	private void soldierMove(int id,BattleField battleField,int x,int y) {
		soldiers[id].move(battleField, x, y);
	}
	private void audienceMove(BattleField battleField,int x,int y) {
		audience.move(battleField, x, y);
	}
	private void findPostionPlaceAudience(BattleField battleField,boolean left) {
		int n=battleField.getSize();
		int base=left?0:5*n/8;
		for(int i=n/8;i<n/4;i++) {
			for(int j=n/8+base;j<n/4+base;j++) {
				if(battleField.isEmpty(i,j)) {
					audienceMove(battleField, i,j);
				}
			}
		}
	}
	public void snakeFormation(BattleField battleField,boolean left) {
		int n=battleField.getSize(),numSoldier=soldiers.length;
		int x=n/2-numSoldier/2,y=n/4;
		if(!left)
			y*=3;
		for(int i=0;i<numSoldier;i++) {
			soldierMove(i, battleField, x++, y);
		}
		findPostionPlaceAudience(battleField,left);
	}
	public void craneFormation(BattleField battleField,boolean left) {
		int n=battleField.getSize(),numSoldier=soldiers.length;
		int x=n/2-numSoldier/2,y=left?n/2:n/2+1;
		for(int i=0;i<numSoldier/2;i++) {
			soldierMove(i, battleField, x++, y);
			y=left?y-1:y+1;
		}
		for(int i=numSoldier/2;i<numSoldier;i++) {
			soldierMove(i, battleField, x++, y);
			y=left?y+1:y-1;
		}
		findPostionPlaceAudience(battleField,left);
	}
	public void gooseFormation(BattleField battleField,boolean left) {
		int n=battleField.getSize(),numSoldier=soldiers.length;
		int x=n/2-numSoldier/2;
		int y=left?numSoldier:n-1-numSoldier;
		for(int i=0;i<numSoldier;i++) {
			soldierMove(i, battleField, x++, y);
			y=left?y-1:y+1;
		}
		findPostionPlaceAudience(battleField,left);
	}
	public void crossFormation(BattleField battleField,boolean left) {
		int n=battleField.getSize(),numSoldier=soldiers.length;
		int x=n/2-numSoldier/2;
		int y=left?n/4:n*3/4;
		for(int i=0;i<numSoldier/2;i++) {
			soldierMove(i, battleField, x, y);
			x+=2;
		}
		y++;
		x-=3;
		for(int i=numSoldier/2;i<numSoldier;i++) {
			soldierMove(i, battleField, x, y);
			x-=2;
		}
		findPostionPlaceAudience(battleField,left);
	}
	public void scaleFormation(BattleField battleField,boolean left) {
		int n=battleField.getSize(),numSoldier=soldiers.length;
		int x=n/2;
		int y=left?n/3:n*2/3;
		int cnt=0;
		for(int i=1;;i+=2) {
			int tx=x;
			for(int j=0;j<i;j++) {
				soldierMove(cnt++, battleField, x++, y);
				if(cnt==numSoldier) {
					findPostionPlaceAudience(battleField,left);
					return;
				}
			}
			x=tx-1;
			y=left?y-1:y+1;
		}
	}
	public void squareFormation(BattleField battleField,boolean left) {
		int n=battleField.getSize(),numSoldier=soldiers.length;
		int x=n/2;
		int y=left?n/2-1:n/2+1;
		soldierMove(0, battleField, x, y);
		y=left?y-1:y+1;
		int cnt=1;
		int cols=(numSoldier-1)/2,gap=0;
		for(int i=0;i<=(cols-1)/2;i++) {
			gap=i+1;
			soldierMove(cnt++, battleField, x-gap, y);
			soldierMove(cnt++, battleField, x+gap, y);
			y=left?y-1:y+1;
		}
		gap=(cols%2==0)?gap:gap-1;
		for(int i=(cols-1)/2+1;i<cols;i++) {
			soldierMove(cnt++, battleField, x-gap, y);
			soldierMove(cnt++, battleField, x+gap, y);
			y=left?y-1:y+1;
			gap--;
		}
		if(cnt<numSoldier)
			soldierMove(cnt++, battleField, x, y);
		findPostionPlaceAudience(battleField,left);
	}
}

class CalabashSide extends Troop{
	CalabashSide(){
		soldiers=new Creature[7];
		audience=new Creature('G');// grandpa
		for(int i=0;i<7;i++)
			soldiers[i]=new Creature((char)('0'+i+1)); // brothers
	}
}

class MonsterSide extends Troop{
	MonsterSide(int num){
		soldiers=new Creature[num];
		soldiers[0]=new Creature('S'); // scorpion
		audience=new Creature('L'); // snake
		for(int i=1;i<num;i++)
			soldiers[i]=new Creature((char)('a'+i-1)); // animals
	}
}

class BattleField{
	public BattleField(int n) {
		this.n=n;
		board=new char[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				board[i][j]='.';
	}
	public void addObject(Creature creature,int x,int y) {
		board[x][y]=creature.getName();
	}
	public void removeObject(Creature creature) {
		int[] pos=creature.getPosition();
		if(board[pos[0]][pos[1]]==creature.getName())
			board[pos[0]][pos[1]]='.';
	}
	public void showBattleField() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
	public int getSize() {
		return n;
	}
	public boolean isEmpty(int x,int y) {
		return board[x][y]=='.';
	}
	private int n;
	private char[][] board;
}


public class Battle {
	Battle(int n,int numMonsters){
		battleField=new BattleField(n);
		troops[0]=new CalabashSide();
		troops[1]=new MonsterSide(numMonsters);
	}
	BattleField battleField;
	Troop[] troops=new Troop[2];
	public void changeFormation(boolean side, String formationName) {
		int id=side?0:1;
		switch (formationName) {
		case "snake":
			troops[id].snakeFormation(battleField, side);
			break;
		case "crane":
			troops[id].craneFormation(battleField, side);
			break;
		case "goose":
			troops[id].gooseFormation(battleField, side);
			break;
		case "cross":
			troops[id].crossFormation(battleField, side);
			break;
		case "scale":
			troops[id].scaleFormation(battleField, side);
			break;
		case "square":
			troops[id].squareFormation(battleField, side);
			break;
		default:
			break;
		}
	}
	public void show() {
		battleField.showBattleField();
		System.out.println();
	}
	
	public static void main(String[] args) {
		Battle battle=new Battle(30, 16);
		battle.changeFormation(true,"snake");
		battle.changeFormation(false,"crane");
		battle.show();
		battle.changeFormation(false,"scale");
		battle.show();
		battle.changeFormation(false,"goose");
		battle.show();
		battle.changeFormation(false,"cross");
		battle.show();
		battle.changeFormation(false,"square");
		battle.show();
	}

}
