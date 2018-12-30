package confrontation;

public class Space {
	String[][] space=new String[25][40];	
	Sorpio sorpio=new Sorpio();
	Sneak sneak=new Sneak();
	Lackeys[] lackeys=new Lackeys[30];
	Grandpa grandpa=new Grandpa();
	Formation formation=new Formation();
	CalabashBrothers[] calabash=new CalabashBrothers[7];	
	public Space() {
		String[] name= {"大  ","二  ","三  ","四  ","五  ","六  ","七  "};
		for(int i=0;i<7;i++) {
			calabash[i]=new CalabashBrothers(" 老"+name[i]);
		}
		for(int i=0;i<30;i++) {
			lackeys[i]=new Lackeys();
		}

	}
	public void setSpace() {
		for(int j=0;j<space[0].length;j++) {
			space[0][j]="  ***  ";
			space[space.length-1][j]="  ***  ";
		}
		formation.sneakFormation(calabash,space);
		sorpio.selectFormation(formation, sorpio, lackeys, space);
		grandpa.setXY(space, 7, 2);
		sneak.setXY(space, 7, 14);
	}
	public void printSpace() {
		for(int i=0;i<space.length;i++) {
			for(int j=0;j<space[i].length;j++) {
				if(space[i][j]!=null) {
					System.out.print(space[i][j]);
				}
				else 
					System.out.print("            ");
			}
			System.out.print("\n");
		}
	}
}
