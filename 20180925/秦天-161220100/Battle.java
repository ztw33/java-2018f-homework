//package qt;

public class Battle {

	public static void main(String[] args) {
		BattleField battleField=new BattleField(30, 30);
		CalabashSide calabashSide=new CalabashSide();
		MonsterSide monsterSide=new MonsterSide(16);
		
		SnakeFormation snakeFormation=new SnakeFormation();
		snakeFormation.format(battleField,calabashSide,true);
		
		Formation[] formations=new Formation[] {new CraneFormation(),new GooseFormation(),
				new CrossFormation(),new ScaleFormation(),new SquareFormation()};
		
		for(Formation formation:formations) {
			formation.format(battleField, monsterSide, false);
			battleField.printBattleField();
		}
		
	
	}

}
