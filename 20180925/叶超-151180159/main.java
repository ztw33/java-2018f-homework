import battlefield.*;
import creature.*;
import zhen.*;
import group.*;

public class main {
	public static void main(String[] args) {
		BattleField field=new BattleField(15,15);
		HumanGroup human=new HumanGroup(field,4,3);
		MonsterGroup monster=new MonsterGroup(field,5,6);
		human.changshe();
		human.grandpacheer();
		monster.yanxing();
		monster.snakecheer();
		field.display();
		System.out.println();
		monster.reset();
		monster.heyi();
		field.display();
		
	}
}
