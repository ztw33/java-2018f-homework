//package qt;

import java.util.List;

public class CrossFormation implements Formation{

	@Override
	public void format(BattleField battleField, Troop troop, boolean left) {
		battleField.reset(left);
		List<Fighter> fighters=troop.getFighters();
		Audience audience=troop.getAudience();
		int numSoldier=fighters.size();
		int x=battleField.getM()/2-numSoldier/2;
		int y=left?battleField.getN()/4:battleField.getN()*3/4;
		for(int i=0;i<numSoldier/2;i++) {
			fighters.get(i).setPosition(x, y);
			battleField.set(fighters.get(i), new Position(x,y));
			x+=2;
		}
		y++;
		x-=3;
		for(int i=numSoldier/2;i<numSoldier;i++) {
			fighters.get(i).setPosition(x, y);
			battleField.set(fighters.get(i), new Position(x,y));
			x-=2;
		}
		Position audPos=battleField.getEmptyPosition(left);
		audience.setPosition(audPos);
		battleField.set(audience, audPos);
	}
}
