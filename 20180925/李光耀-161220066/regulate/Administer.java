package regulate;

import creature.CreatureType;
import space.Board;
import space.Formation;

public class Administer {
	private Board myBoard=new Board();	//需要固定
	
	public void getputNextMonsterFormation(){
		if(myBoard.putFormation(Formation.getNextMonsterFormation().getFormation())==false){
			myBoard.putFormation(Formation.getPreMonsterFormation().getFormation());
		}
	}
	
	public void getputHuLuFormation(){
		myBoard.putFormation(Formation.getHuLuFormation().getFormation());
	}
	
	public void putGrandPa(){
		myBoard.putGrandPa();
	}
	
	public void putSnake(){
		myBoard.putSnake();
	}
	
	public void moveRightManual(CreatureType c){
		myBoard.moveManual(c,1,0);
	}
	
	public void moveLeftManual(CreatureType c){
		myBoard.moveManual(c,-1,0);
	}
	
	public void moveUpManual(CreatureType c){
		myBoard.moveManual(c,0,-1);
	}
	
	public void moveDownManual(CreatureType c){
		myBoard.moveManual(c,0,1);
	}
	
	public Administer() {
		// TODO Auto-generated constructor stub
	}
	
	public Board getBoard(){
		return myBoard;
	}
	 
	public void show(){
		myBoard.show();
	}
	public static void main(String[] args) {
	}
}
