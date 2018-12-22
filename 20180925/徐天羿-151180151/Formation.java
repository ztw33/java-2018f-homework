package calabash;

public class Formation {
	int number;
	Field area = new Field();
	
	Formation(Field area){
		this.area = area;
	}
	
	public void setGrandpa() {
		Grandpa yeye = new Grandpa();
		area.field[4][1] = yeye.getName() + ':' + yeye.cheerG();
	}
	
	public void setSnake() {
		Snake snake = new Snake();
		area.field[9][13] = snake.getName() + ':' + snake.cheerS();
	}
	
	public void snakeFormation() {
		int[] locationX = {4,5,6,7,8,9,10};
		int[] locationY = {3,3,3,3,3,3,3};
		
		for(int i = 0; i < locationX.length; i++) {
			CalabashBrothers bro = new CalabashBrothers(i);
			area.field[locationX[i]][locationY[i]] = bro.getName();
		}
	}
	
	public void craneFormation() {
		int[] locationX = {5,6,7,7,6,5};
		int[] locationY = {8,9,10,12,13,14};
		
		for(int i = 0; i < locationX.length; i++) {
			Monsters bro = new Monsters();
			area.field[locationX[i]][locationY[i]] = bro.getName();
		}
		
		Scorpion sco = new Scorpion();
		area.field[8][11] = sco.getName();
	}
	
	public void gooseFormation() {
		int[] locationX = {10,9,8,6,5,4};
		int[] locationY = {8,9,10,12,13,14};
		
		for(int i = 0; i < locationX.length; i++) {
			Monsters bro = new Monsters();
			area.field[locationX[i]][locationY[i]] = bro.getName();
		}
		
		Scorpion sco = new Scorpion();
		area.field[7][11] = sco.getName();
	}
	
	public void yokeFormation() {
		int[] locationX = {4,5,6,8,9,10};
		int[] locationY = {12,11,12,12,11,12};
		
		for(int i = 0; i < locationX.length; i++) {
			Monsters bro = new Monsters();
			area.field[locationX[i]][locationY[i]] = bro.getName();
		}
		
		Scorpion sco = new Scorpion();
		area.field[7][11] = sco.getName();
	}
	
	public void scaleFormation() {
		int[] locationX = {7,4,6,7,6,7,8,7};
		int[] locationY = {10,11,11,11,12,12,12,13};
		
		for(int i = 0; i < locationX.length; i++) {
			Monsters bro = new Monsters();
			area.field[locationX[i]][locationY[i]] = bro.getName();
		}
		
		Scorpion sco = new Scorpion();
		area.field[5][12] = sco.getName();
	}
	
	public void arrowFormation() {
		int[] locationX = {5,4,6,7,8,9,5};
		int[] locationY = {10,11,11,11,11,11,12};
		
		for(int i = 0; i < locationX.length; i++) {
			Monsters bro = new Monsters();
			area.field[locationX[i]][locationY[i]] = bro.getName();
		}
		
		Scorpion sco = new Scorpion();
		area.field[5][11] = sco.getName();
	}
	
}