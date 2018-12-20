package creature;

public class CalabashBody extends Creature {
	public enum COLOR {RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE}
	public String[] allName= {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	private int no;
    private COLOR color;
    
    public CalabashBody(int no) {
    	this.no = no;
    	super.name = allName[no];
    	this.color = COLOR.values()[no];
    }
    public int getNo() {
    	return no;
    }
    public String getName() {
    	return super.name;
    }
    public COLOR getColor() {
    	return color;
    }

}