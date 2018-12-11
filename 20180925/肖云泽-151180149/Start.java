import creature.*;
import battlefield.*;
import infos.Infos;

public class Start {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Battlefield b = new Battlefield(Infos.BATTLEFIELD_SCALE);
		Queue c = new Queue(Infos.CALABASHBROTHERQUEUE);
		Queue e = new Queue(Infos.ENEMYQUEUE);
		c.randomOrder();
		c.calaSort();
		Formation f1 = Formation.SNAKE_FORMATION;
		f1.arr.setStartpoint(new Position(0,4));
		f1.arr.normalize();
		b.place(c, f1);
		Formation f2 = Formation.ECHELON_FORMATION;
		f2.arr.setStartpoint(new Position(7,4));
		f2.arr.normalize();
		b.place(e, f2);
		Creature c1 = new Grandpa();
		Creature c2 = new Serpent();
		b.place(c1, new Position(0,7));
		b.place(c2, new Position(14,7));
		b.showBattlefield();
		
		Formation f3 = Formation.ARROW_FORMATION;
		f3.arr.setStartpoint(new Position(7,4));
		f3.arr.normalize();
		b.changeFormation(e, f2, f3);
		b.showBattlefield();
	}
}
