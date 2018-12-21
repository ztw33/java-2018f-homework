import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class Team implements TeamInterface{
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
	public void showTeam() {
		Iterator<Warrior> it = team.iterator();
		while(it.hasNext()) {
			it.next().showMe();
		}
	}
	public String getSide() {
		return side;
	}
	public <T extends Warrior> void add(T temp) {
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
	
	public String toString() {
		String s = new String();
		Iterator<Warrior> it = team.iterator();
		while(it.hasNext()) {
			s += it.next();
			s += "\n";
		}
		return s;
		
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
	
	// add sort method here
	public void sortTeam()
	{
		Collections.sort(team, comp);
	}
	
	Comparator<Warrior> comp = new Comparator() {
		public int compare(Object a0, Object a1) {
			try {
				if(! (a0 instanceof Warrior)) {
					throw new Exception("Type Error!");
				}
				if(! (a1 instanceof Warrior)) {
					throw new Exception("Type Error!");
				}
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
			Warrior w1 = (Warrior) a0;
			Warrior w2 = (Warrior) a1;
			
			if(side == "GoodMan") {
				if(w1.getName() == "老爷爷")
					return 1;
				else if(w2.getName() == "老爷爷")
					return -1;
				return 0;
			}
			if(side == "BadMan") {
				if(w1.getName() == "蛇精")
					return 1;
				else if(w1.getName() == "蝎子精")
					return -1;
				
				if(w2.getName() == "蛇精")
					return -1;
				else if(w2.getName() == "蝎子精")
					return 1;
				
				int c1 = (int)w1.getName().charAt(2);
				int c2 = (int)w2.getName().charAt(2);
				return c1-c2;
			}
			return 0;
		}
	};
		
	
}