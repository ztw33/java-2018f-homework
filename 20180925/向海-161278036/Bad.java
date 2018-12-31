package confrontation;
import java.util.ArrayList;

class Sneak extends Organisms{
	public Sneak() {
		super("  蛇精   ");
		this.type=3;
	}
	public void cheerUp() {
		
	}
}
class Sorpio extends Organisms{
	public Sorpio() {
		super(" 蝎子精 ");
		this.type=4;
	}

}
class Lackeys extends Organisms{
	public Lackeys() {
		super(" 小喽啰 ");
		this.type=5;
	}
}
public class Bad {
	Sneak sneak;
	Sorpio sorpio;
	ArrayList<Lackeys> LackeysList;
	Formation badFormation;
	Bad(){
		sneak=new Sneak();
		sorpio=new Sorpio();
		LackeysList=new ArrayList<Lackeys>();
	}
	public void selectFormation(Battlefield battle) {
		//做一个选择
		badFormation=new FengShi();
		badFormation.arrange(this, battle);
	}
}
