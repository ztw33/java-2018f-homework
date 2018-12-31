package creature;

public class CalabashBrother extends Good {
	
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

}
