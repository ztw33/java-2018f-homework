package Assignment2;

public class Cucurbit {
		private Color color;
		private int ranking; //from 1 to 7;
		
		Cucurbit(int i,Color c){
			ranking = i;
			color = c;
		}
		
		public void numberOff(){
			System.out.print(ranking+"ÍÞ ");
		}
		public void colorOff(){
			System.out.print(color+" ");
		}
		public int getNum(){
			return ranking;
		}
		public Color getColor(){
			return color;
		}
}

enum Color{ RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE};
