
public interface TeamInterface {
	abstract public String toString();
	abstract public void showTeam() ;
	
	abstract public String getSide();
	abstract public <T extends Warrior> void add(T temp);
	abstract public void goBattle(Warrior [][] fields, int[][] place);
	abstract public void checkMember() throws MyException;

}
