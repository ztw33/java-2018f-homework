package calabash;

public class Control {

	public static void main(String[] args) {
		Calabash[] CU= {new Calabash(2,Color.ORANGE),new Calabash(6,Color.BLUE),new Calabash(1,Color.RED),new Calabash(3,Color.YELLOW),new Calabash(4,Color.GREEN),
				new Calabash(7,Color.PURPLE),new Calabash(5,Color.CYAN)};  //initialize calabash brothers.
		
		int N = 7; //calabash brothers
		MySort Sort = new MySort();
		Sort.BubbleS(CU, N);
		
		int M = 24; //space 
		Formation form = new Formation(M);
		
		form.formationC(CU,Form.SERPEN,N,'C');
		//form.printStation();
		
		int S = 7; //scorpion and monsters
		Monster[] MO = new Monster[S];
		for(int i = 0; i < S; i++)
			MO[i] = new Monster();
		MO[0].setAttr(Attribute.SCORPION);  //the leader is scorpion
		form.formationC(MO,Form.WING,S,'S');
		//form.printStation();
		Grandpa GR = new Grandpa();
		Serpent SR = new Serpent();
		
		form.formationS(GR,'G');
		form.formationS(SR,'S');
		
		//form.printStation();
		
		GR.cheerUp();
		SR.cheerUp();
		form.printStation();
		
		form.changeForm(MO, Form.SHIELD, S, 'M');;
		GR.cheerUp();
		SR.cheerUp();
		form.printStation();
		
	}

}
