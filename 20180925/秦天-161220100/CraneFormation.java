//package qt;

import java.util.List;

public class CraneFormation implements Formation{

	@Override
	public void format(BattleField battleField, Troop troop, boolean left) {
		battleField.reset(left);
		List<Fighter> fighters=troop.getFighters();
		Audience audience=troop.getAudience();
		int numSoldier=fighters.size();
		int x=battleField.getM()/2-numSoldier/2,y=left?battleField.getN()/2:battleField.getN()/2+1;
		for(int i=0;i<numSoldier/2;i++) {
			fighters.get(i).setPosition(x, y);
			battleField.set(fighters.get(i), new Position(x,y));
			x++;
			y=left?y-1:y+1;
		}
		for(int i=numSoldier/2;i<numSoldier;i++) {
			fighters.get(i).setPosition(x, y);
			battleField.set(fighters.get(i), new Position(x,y));
			x++;
			y=left?y+1:y-1;
		}
		Position audPos=battleField.getEmptyPosition(left);
		audience.setPosition(audPos);
		battleField.set(audience, audPos);
	}

}
