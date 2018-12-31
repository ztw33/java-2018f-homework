package world.creatures;

/* 七个葫芦娃 */

public final class Brothers extends Creature {
	
	enum Members {
		Bro1("老大", "红色", 'A'), 
		Bro2("老二", "橙色", 'B'), 
		Bro3("老三", "黄色", 'C'),
		Bro4("老四", "绿色", 'D'), 
		Bro5("老五", "青色", 'E'), 
		Bro6("老六", "蓝色", 'F'), 
		Bro7("老七", "紫色", 'G');
		
	    public String rank;
	    public String color;
	    public char symbol;
	    private Members(String rank, String color, char symbol) { // 构造方法
	        this.rank = rank;
	        this.color = color;
	        this.symbol = symbol;
	    }
	}
	
	private Members bro;
	
    public Brothers(int b) { // b 从 0 到 6，代表老大到老七，若不在此范围则取 mod 7
    	super();
        bro = Members.values()[b % 7];
        name = "葫芦娃" + bro.rank;
        symbol = bro.symbol;
    }
    
    public String getColor() {
        return bro.color;
    }
}
