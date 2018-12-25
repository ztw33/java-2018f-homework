
import creatures.*;
import battlefield.*;
import formation.*;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Battlefield b = new Battlefield();
		Queue<Creature> q_bad = new Queue<>(new Creature[] {new Scorpion(),new Minion(),
				new Minion(),new Minion(),new Minion(),new Minion(),new Minion()});
		b.placeQueue(q_bad, new EchelonFormation());
		Queue<Creature> q_good = new Queue<>(new Creature[] {new CalabashBrother(0),new CalabashBrother(1),new CalabashBrother(2),
				new CalabashBrother(3),new CalabashBrother(4),new CalabashBrother(5),new CalabashBrother(6)});
		q_good.randomOrder();
		q_good.calaSort();
		b.placeQueue(q_good, new SnakeFormation());
		b.place(new Position(0,7), new Grandpa());
		b.place(new Position(14,7), new Serpent());
		b.showBattlefield();
		
		Queue<Creature> q_bad2 = new Queue<>(new Creature[] {new Scorpion(),new Minion(),
				new Minion(),new Minion(),new Minion(),new Minion(),new Minion(),
				new Minion(),new Minion(),new Minion(),new Minion(),new Minion(),new Minion()});
		b.changeFormation(q_bad, q_bad2, new EchelonFormation(), new ArrowFormation());
		b.showBattlefield();
		
		Queue<Creature> q_bad3 = new Queue<>(new Creature[] {new Scorpion(),new Minion(),
				new Minion(),new Minion(),new Minion(),new Minion(),new Minion()});
		b.changeFormation(q_bad2, q_bad3, new ArrowFormation(), new WingFormation());
		b.showBattlefield();
	}

}
