import creatures.*;
import formation.*;
import battlefield.*;
import infos.Infos;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Battlefield b = new Battlefield(Infos.BATTLEFIELD_SCALE);
		//calabashbrothers
		Queue q_calabro = new Queue();
		q_calabro.sevenBrothers();
		q_calabro.randomOrder();
		SnakeFormation formation_s= new SnakeFormation(Infos.FORMATION_SCALE);
		b.place(formation_s, new Position(0,4), q_calabro);
		//badguys
		EchelonFormation formation_e = new EchelonFormation(Infos.FORMATION_SCALE);
		Queue q_badguys = new Queue();
		for (int i=0; i<formation_e.getLength(); i++) {
			if(i == 0) {
				q_badguys.appendCreature(new Scorpion());
			}else {
				q_badguys.appendCreature(new Minion());
			}
		}
		b.place(formation_e, new Position(7,4), q_badguys);
		//grandpa & serpent
		Grandpa gp = new Grandpa();
		b.place(new Position(0,7), gp);
		Serpent s = new Serpent();
		b.place(new Position(14,7), s);
		b.showBattlefield();
		//change formation
		ArrowFormation formation_a = new ArrowFormation(Infos.FORMATION_SCALE);
		for (int i=formation_e.getLength(); i<formation_a.getLength(); i++) {
			q_badguys.appendCreature(new Minion());
		}
		b.changeFormation(formation_a, q_badguys, formation_e, new Position(7,4));
		b.showBattlefield();
	}
}
