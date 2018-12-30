package creature;

import javafx.scene.image.Image;

//import java.util.Comparator;

public class CalabashBrother extends Good implements Comparable<CalabashBrother> {
	
	private int rank;
	private String name;
	private COLOR color;
	
	public CalabashBrother(int r, String n, COLOR c) {
		// TODO Auto-generated constructor stub
		rank = r;
		name = n;
		color = c;
	}
	
	public int getRank() { return rank; }
	
	public String getName() { return name; }
	
	public COLOR getColor() { return color; }

	@Override
	public String toString() {
		String ret = null;
		switch (color) {
		case RED:
			ret = "\033[91;4m" + name + "\033[0m";
			break;
		case ORANGE:
			ret = "\033[33;4m" + name + "\033[0m";
			break;
		case YELLOW:
			ret = "\033[93;4m" + name + "\033[0m";
			break;
		case GREEN:
			ret = "\033[92;4m" + name + "\033[0m";
			break;
		case CYAN:
			ret = "\033[94;4m" + name + "\033[0m";
			break;
		case BLUE:
			ret = "\033[96;4m" + name + "\033[0m";
			break;
		case PURPLE:
			ret = "\033[95;4m" + name + "\033[0m";
			break;
		default:
			break;
		}
		return ret;
	}


	@Override
	public int compareTo(CalabashBrother b) {
		// TODO Auto-generated method stub
        if (this.rank > b.rank) {
            return 1;
        } else {
            return -1;
        }
	}

	@Override
	public Image getImage() {
		Image ret = null;
		switch (color) {
		case RED:
			ret = new Image("img/huluwa1.png");
			break;
		case ORANGE:
			ret = new Image("img/huluwa2.png");
			break;
		case YELLOW:
			ret = new Image("img/huluwa3.png");
			break;
		case GREEN:
			ret = new Image("img/huluwa4.png");
			break;
		case CYAN:
			ret = new Image("img/huluwa5.png");
			break;
		case BLUE:
			ret = new Image("img/huluwa6.png");
			break;
		case PURPLE:
			ret = new Image("img/huluwa7.png");
			break;
		default:
			break;
		}
		return ret;
	}

}
