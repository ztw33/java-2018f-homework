package confrontation;

public class Formation {
	public Formation() {
		
	}
	public void sneakFormation(Organisms[] calabash,String[][] space) {
			for(int i=0;i<7;i++) {
				calabash[i].setXY(space,8+i,5);
			}
	}
	public void sneakFormation(Organisms sorpio,Organisms[] lackeys,String[][] space) {
		sorpio.setXY(space, 8, 15);
		for(int i=0;i<=5;i++) {
			lackeys[i].setXY(space, 9+i, 15);
		}
	}
	public void craneFormation(Organisms sorpio,Organisms[] lackeys,String[][] space) {
		sorpio.setXY(space,8,15);
		lackeys[0].setXY(space, 8, 22);
		lackeys[1].setXY(space, 9, 16);
		lackeys[2].setXY(space, 9, 21);
		lackeys[3].setXY(space, 10, 17);
		lackeys[4].setXY(space, 10, 20);
		lackeys[5].setXY(space, 11, 19);
	}
	public void echelonFormation(Organisms sorpio,Organisms[] lackeys,String[][] space) {
		sorpio.setXY(space, 8, 15);
		for(int i=0;i<=4;i++) {
			lackeys[i].setXY(space, 9+i, 14-i);	
		}
	}
	public void yokeFormation(Organisms sorpio,Organisms[] lackeys,String[][] space) {
		sorpio.setXY(space, 8, 15);
		lackeys[0].setXY(space, 9, 14);
		lackeys[1].setXY(space, 10, 15);
		lackeys[2].setXY(space, 11, 14);
		lackeys[3].setXY(space, 12, 15);
		lackeys[4].setXY(space, 13, 14);
	}
	public void fishFormation(Organisms sorpio,Organisms[] lackeys,String[][] space) {
		sorpio.setXY(space, 11, 15);
		lackeys[0].setXY(space, 12, 16);
		lackeys[1].setXY(space, 13, 14);
		lackeys[2].setXY(space, 13, 15);
		lackeys[3].setXY(space, 13, 16);
		lackeys[4].setXY(space, 14, 13);
		lackeys[5].setXY(space, 14, 14);
		lackeys[6].setXY(space, 14, 15);
		lackeys[7].setXY(space, 14, 16);
		lackeys[8].setXY(space, 15, 15);
	}
	public void squareFormation(Organisms sorpio,Organisms[] lackeys,String[][] space) {
		sorpio.setXY(space, 11, 14);
		lackeys[0].setXY(space, 10, 15);
		lackeys[1].setXY(space, 12, 15);
		lackeys[2].setXY(space, 9, 16);
		lackeys[3].setXY(space, 13, 16);
		lackeys[4].setXY(space, 10, 17);
		lackeys[5].setXY(space, 12, 17);
		lackeys[6].setXY(space, 11, 18);
	}
	public void moonFormation(Organisms sorpio,Organisms[] lackeys,String[][] space) {
		sorpio.setXY(space, 11, 14);
		lackeys[0].setXY(space, 11, 16);
		lackeys[1].setXY(space, 11, 18);
		lackeys[2].setXY(space, 10, 14);
		lackeys[3].setXY(space, 10, 16);
		lackeys[4].setXY(space, 10, 18);
		lackeys[5].setXY(space, 12, 14);
		lackeys[6].setXY(space, 12, 16);
		lackeys[7].setXY(space, 12, 18);
		lackeys[8].setXY(space, 9, 17);
		lackeys[9].setXY(space, 9, 19);
		lackeys[10].setXY(space, 8, 18);
		lackeys[11].setXY(space, 8, 20);
		lackeys[12].setXY(space, 7, 21);
		lackeys[13].setXY(space, 13, 17);
		lackeys[14].setXY(space, 13, 19);
		lackeys[15].setXY(space, 14, 18);
		lackeys[16].setXY(space, 14, 20);
		lackeys[16].setXY(space, 15, 21);
	}
	public void shapeFormation(Organisms sorpio,Organisms[] lackeys,String[][] space) {
		sorpio.setXY(space, 8, 10);
		for(int i=0;i<5;i++) {
			lackeys[i].setXY(space, 9+i, 10);
		}
		for(int i=5;i<8;i++) {
			lackeys[i].setXY(space, 4+i, 14-i);
		}
		for(int i=8;i<11;i++) {
			lackeys[i].setXY(space, 1+i, 3+i);
		}
	}
}
