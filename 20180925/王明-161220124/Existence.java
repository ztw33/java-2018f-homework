package confront;

public abstract class Existence {
	private String name;           //名字
	
	public Existence() {           
		name = null;              
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String a) {
		name = a;
	}
}

abstract class CalabashWorld extends Existence {
	private String quality;        //性质，有“好”“坏”“中立”三种
	private Coordinate coordinate; //坐标，在战场上的位置
	
	public CalabashWorld() {                
		quality = null;
		coordinate = null;
	}
	
	public String getQuality() {
		return quality;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate a) {
		coordinate = a;
	}
	
	public void removeCoordinate() {
		coordinate = null;
	}
	
	public void setQuality(String a) {
		quality = a;
	}
}

abstract class Justice extends CalabashWorld {
	public Justice() {
		this.setQuality("好");
	}
}

abstract class Evil extends CalabashWorld {
	public Evil() {
		this.setQuality("坏");
	}
}

interface WarMan{
	public void LeaveBattleground(Battleground bg);
}

interface Fighter extends WarMan{
	public void GotoBattleground(Battleground bg, Formation form);
}

interface SideLooker extends WarMan{
	public void Lookatside(Battleground bg, Coordinate a);
}

interface FightLeader extends Fighter{
	public void SetLeaderground(Coordinate a, Formation form);
	public void GiveOrder(String a, Formation form);
}

class CalabashBro extends Justice implements FightLeader{
	private String color;
	private int rank;
	
	public CalabashBro(int i) {
//		this.setQuality("好");
		switch(i) {
		case 1:
			this.setName("老大");
			color = "红色";
			rank = 1;
			break;
		case 2:
			this.setName("老二");
			color = "橙色";
			rank = 2;
			break;
		case 3:
			this.setName("老三");
			color = "黄色";
			rank = 3;
			break;
		case 4:
			this.setName("老四");
			color = "绿色";
			rank = 4;
			break;
		case 5:
			this.setName("老五");
			color = "青色";
			rank = 5;
			break;
		case 6:
			this.setName("老六");
			color = "蓝色";
			rank = 6;
			break;
		case 7: 
			this.setName("老七");
			color = "紫色";
			rank = 7;
			break;
		}
	}
	
	public String getColor() {
		return color;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void SetLeaderground(Coordinate a, Formation form) {   //设置领导点，即阵型的关键点的位置（所谓关键点就是决定阵型位置的点）
		if(color == "红色") {
			form.setLeader(a);
		}
		else {
			System.out.println("该葫芦娃没有权利决定领导点");
		}
	}
	
	public void GiveOrder(String a, Formation form) {             //发号施令，即决定摆出哪一种阵型
		if(color == "红色") {
			form.setLayout(a);
		}
		else {
			System.out.println("该葫芦娃没有权利决定阵型");
		}
	}
	
	public void GotoBattleground(Battleground bg, Formation form) {      //奔赴战场，根据阵型找到自己站立的位置
		for(int i = 0; i < form.getNumber(); i++) {
			if(bg.getSpot()[form.getLayout()[i].getX()][form.getLayout()[i].getY()].SpotEmpty() == true) {
				this.setCoordinate(bg.getSpot()[form.getLayout()[i].getX()][form.getLayout()[i].getY()].getCoordinate());
				bg.getSpot()[form.getLayout()[i].getX()][form.getLayout()[i].getY()].setExistence(this);
				break;
			}
		}
	}
	
	public void LeaveBattleground(Battleground bg) {            //离开战场，直接撤退
		bg.getSpot()[this.getCoordinate().getX()][this.getCoordinate().getY()].removeExistence();
		this.removeCoordinate();
	}
}

class Grandpa extends Justice implements SideLooker{
	public Grandpa() {
		this.setName("老爷爷");
//		this.setQuality("好");
	}
	
	public void Lookatside(Battleground bg, Coordinate a) {        //旁观，即直接选取战场中无人的位置站立
		this.setCoordinate(a);
		bg.getSpot()[a.getX()][a.getY()].setExistence(this);
	}
	
	public void LeaveBattleground(Battleground bg) {
		bg.getSpot()[this.getCoordinate().getX()][this.getCoordinate().getY()].removeExistence();
		this.removeCoordinate();
	}
}

class DemonSnake extends Evil implements SideLooker{
	public DemonSnake() {
		this.setName("蛇精");
//		this.setQuality("坏");
	}
	
	public void Lookatside(Battleground bg, Coordinate a) {
		this.setCoordinate(a);
		bg.getSpot()[a.getX()][a.getY()].setExistence(this);
	}
	
	public void LeaveBattleground(Battleground bg) {
		bg.getSpot()[this.getCoordinate().getX()][this.getCoordinate().getY()].removeExistence();
		this.removeCoordinate();
	}
}

class DemonScorpion extends Evil implements FightLeader {
	public DemonScorpion() {
		this.setName("蝎子精");
//		this.setQuality("坏");
	}
	
	public void SetLeaderground(Coordinate a, Formation form) {
		form.setLeader(a);
	}
	
	public void GiveOrder(String a, Formation form) {
		form.setLayout(a);
	}

	public void GotoBattleground(Battleground bg, Formation form) {
		if(bg.getSpot()[form.getLayout()[0].getX()][form.getLayout()[0].getY()].SpotEmpty() == true) {
			this.setCoordinate(bg.getSpot()[form.getLayout()[0].getX()][form.getLayout()[0].getY()].getCoordinate());
			bg.getSpot()[form.getLayout()[0].getX()][form.getLayout()[0].getY()].setExistence(this);
		}
	}
	
	public void LeaveBattleground(Battleground bg) {
		bg.getSpot()[this.getCoordinate().getX()][this.getCoordinate().getY()].removeExistence();
		this.removeCoordinate();
	}
}

class Lackey extends Evil implements Fighter{
	public Lackey() {
		this.setName("小喽啰");
//		this.setQuality("坏");
	}
	
	public void GotoBattleground(Battleground bg, Formation form) {
		for(int i = 0; i < form.getNumber(); i++) {
			if(bg.getSpot()[form.getLayout()[i].getX()][form.getLayout()[i].getY()].SpotEmpty() == true) {
				this.setCoordinate(bg.getSpot()[form.getLayout()[i].getX()][form.getLayout()[i].getY()].getCoordinate());
				bg.getSpot()[form.getLayout()[i].getX()][form.getLayout()[i].getY()].setExistence(this);
				break;
			}
		}
	}
	
	public void LeaveBattleground(Battleground bg) {
		bg.getSpot()[this.getCoordinate().getX()][this.getCoordinate().getY()].removeExistence();
		this.removeCoordinate();
	}
}
