package calabash;

public class Field {
	String[][] field;
	
	Field(){
		this.field = new String[15][15];
	}
	
	public void createField() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				field[i][j] = "\t";
			}
		}
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
				field[i][j] = "\t";
			}
		}
	}
	
	public static void main(String[] args) {
		Field field = new Field();
		field.createField();
		Formation form = new Formation(field);
		form.snakeFormation();
		form.setGrandpa();
		System.out.println("**********craneFormation**********");
		form.craneFormation();
		form.setSnake();
		field.printField();
		field.clearMonster();
		System.out.println("**********gooseFormation**********");
		form.gooseFormation();
		form.setSnake();
		field.printField();
		field.clearMonster();
		System.out.println("**********scaleFormation**********");
		form.scaleFormation();
		form.setSnake();
		field.printField();
		field.clearMonster();
		System.out.println("**********arrowFormation**********");
		form.arrowFormation();
		form.setSnake();
		field.printField();
		field.clearMonster();
		System.out.println("**********yokeFormation**********");
		form.yokeFormation();
		form.setSnake();
		field.printField();
	}
}
