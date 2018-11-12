package javahw3;

import java.util.ArrayList;
import java.util.Iterator;

public class Team{
	/*
	 * Variables: ArrayList<Warrior> team;
	 * Methods: showWarriors();
	 * check the team member to ensure no enemy
	 * */
	public ArrayList<Warrior> team;
	private String side;
	Team(String side){
		team = new ArrayList<Warrior>();
		this.side = side;
	}
	public void showWarriors() {
		Iterator<Warrior> it = team.iterator();
		while(it.hasNext()) {
			it.next().showMe();
		}
	}
	public String getSide() {
		return side;
	}
	public void add(Warrior temp) {
		team.add(temp);
	}
	
	public void goBattle(Warrior [][] fields, int[][] place) {
		for(int i=0; i<team.size(); i++) {
			int m = place[i][0];
			int n = place[i][1];
			team.get(i).changePosition(m, n);
			fields[m][n] = team.get(i);
		}
	}
	
	public void checkMember() throws MyException{
		Iterator<Warrior> it = team.iterator();
		while(it.hasNext()) {
			Warrior w = it.next();
			try {
				if(w.getTeam() != side)
					throwMyException(w.getName());
			}catch(MyException e){
				w.changeTeam(side);
				System.out.println("changed the spy!");
			}	
		}
	}
	
	public void throwMyException(String name) throws MyException{
		throw new MyException(name + " is a spy in " + side);
	}
}