//package qt;

public class MonsterSide extends Troop{
	private int numMonsters;
	public MonsterSide(int numMonsters) {
		this.numMonsters=numMonsters;
		fighters.add(new Scorpion());
		for(int i=1;i<numMonsters;i++) {
			fighters.add(new SmallMonster(Character.toString((char)('a'-1+i))));
		}
		audience=new Snake();
	}
}
