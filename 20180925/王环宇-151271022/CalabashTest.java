import static org.junit.Assert.*;
import org.junit.Test;

public class CalabashTest {
	
	
	@Test
	// Test the shuffle method
	public void shuffleTest() {
		Team teamBad = new Team("BadMan");
		Team copy = new Team("BadMan");
		teamBad.load(FightField.pwd + "BadMan.txt");
		copy.load(FightField.pwd + "BadMan.txt");
		
		FightField.shuffle(teamBad);
		
		for(int i=0; i<teamBad.team.size(); i++) {
			if(teamBad.team.get(i).getName() != copy.team.get(i).getName() )
				return;
		}
		fail("Shuffle doesn't work.");
	}
	
	
	@Test
	public void sortTest() {
		Team teamBad = new Team("BadMan");
		Team copy = new Team("BadMan");
		teamBad.load(FightField.pwd + "BadMan.txt");
		copy.load(FightField.pwd + "BadMan.txt");
		
		FightField.shuffle(teamBad);
		teamBad.sortTeam();
		for(int i=0; i<teamBad.team.size(); i++) {
			if(teamBad.team.get(i).getName().compareTo(copy.team.get(i).getName()) !=0 )
				fail("sort doesn't work.");
		}	
	}
	
	
	@Test
	public void findSpyTest() throws Exception{
		Team teamBad = new Team("BadMan");
		teamBad.load(FightField.pwd + "BadMan.txt");
		FightField.shuffle(teamBad);
		teamBad.checkMember();
		String team = teamBad.getSide();
		for(Warrior w: teamBad.team) {
			if(w.getTeam().compareTo(team) != 0) {				
				fail("Didn't find the spy");
				}
		}
	}
}
