//package qt;

import java.util.List;

public class GooseFormation implements Formation{
	
	@Override
	public void format(BattleField battleField, Troop troop, boolean left) {
		battleField.reset(left);
		List<Fighter> fighters=troop.getFighters();
		Audience audience=troop.getAudience();
		int numSoldier=fighters.size();
		int x=battleField.getM()/2-numSoldier/2;
		int y=left?numSoldier:battleField.getN()-1-numSoldier;
		for(int i=0;i<numSoldier;i++) {
			fighters.get(i).setPosition(x, y);
			battleField.set(fighters.get(i), new Position(x,y));
			x++;
			y=left?y-1:y+1;
		}
		Position audPos=battleField.getEmptyPosition(left);
		audience.setPosition(audPos);
		battleField.set(audience, audPos);
	}
}
