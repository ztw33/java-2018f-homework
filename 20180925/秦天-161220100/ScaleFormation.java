//package qt;

import java.util.List;

public class ScaleFormation implements Formation{

	@Override
	public void format(BattleField battleField, Troop troop, boolean left) {
		battleField.reset(left);
		List<Fighter> fighters=troop.getFighters();
		Audience audience=troop.getAudience();
		int numSoldier=fighters.size();
		int x=battleField.getM()/2;
		int y=left?battleField.getN()/3:battleField.getN()*2/3;
		int cnt=0;
		for(int i=1;;i+=2) {
			int tx=x;
			for(int j=0;j<i;j++) {
				fighters.get(cnt).setPosition(x, y);
				battleField.set(fighters.get(cnt), new Position(x,y));
				cnt++;
				x++;
				if(cnt==numSoldier) {
					Position audPos=battleField.getEmptyPosition(left);
					audience.setPosition(audPos);
					battleField.set(audience, audPos);
					return;
				}
			}
			x=tx-1;
			y=left?y-1:y+1;
		}
	}
}
