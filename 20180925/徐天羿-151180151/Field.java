package calabash;
import java.util.ArrayList;
import java.util.Collections;

public class Field {
	String[][] field = new String[15][15];  //战场的每一个都有一个Creature对象，虚无是一种特殊的Creature；
	
	public void initialField() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				field[i][j] = "一一";
			}
		}
	}
	
	public void updateField(int ix, int iy, Creature crea) {
		field[ix][iy] = crea.getName();
	}
	
	public void printField() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}
	
	public void clearMonster() {
		for(int i = 0; i < 15; i++) {
			for(int j = 8; j < 15; j++) {
				field[i][j] = "一一";
			}
		}
	}
	
	public static void main(String[] args) {
		//initialize
		Field field = new Field();
		field.initialField();
		Grandpa gra = new Grandpa(7, 1);
		Snake sna = new Snake(7, 13);
		CalabashColor[] brosColor = CalabashColor.values();
		ArrayList<CalabashBrothers> bros = new ArrayList<CalabashBrothers>();
		for(int i = 0; i < 7; i++) {
			bros.add(new CalabashBrothers(brosColor[i]));
		}
		Sort sort = new Sort();
		
		//form calabashbrothers
		System.out.println("**********randomCalabash**********");
		Collections.shuffle(bros);
		SnakeFormation snF = new SnakeFormation(field);
		snF.setFormation(bros);
		field.printField();
		System.out.println("**********sortCalabash**********");
		sort.bubbleSort(bros);
		snF.setFormation(bros);
		field.updateField(gra.getX(), gra.getY(), gra);
		field.printField();
		
		//form monsters
		System.out.println("**********craneFormation**********");
		CraneFormation crF = new CraneFormation(field);
		ArrayList<Monsters> mons = new ArrayList<Monsters>();
		mons.add(new Scorpion());
		for( int i = 1; i < crF.getSize(); i++) {
			mons.add(new Monsters());
		}
		crF.setFormation(mons);
		field.updateField(sna.getX(), sna.getY(), sna);
		field.printField();
		field.clearMonster();
		mons.clear();
		
		System.out.println("**********squareFormation**********");
		SquareFormation sqF = new SquareFormation(field);
		mons.add(new Scorpion());
		for( int i = 1; i < crF.getSize(); i++) {
			mons.add(new Monsters());
		}
		sqF.setFormation(mons);
		field.updateField(sna.getX(), sna.getY(), sna);
		field.printField();
		field.clearMonster();
		mons.clear();
		
		System.out.println("**********arrowFormation**********");
		ArrowFormation arF = new ArrowFormation(field);
		mons.add(new Scorpion());
		for( int i = 1; i < crF.getSize(); i++) {
			mons.add(new Monsters());
		}
		arF.setFormation(mons);
		field.updateField(sna.getX(), sna.getY(), sna);
		field.printField();
		field.clearMonster();
		mons.clear();
	}
}
