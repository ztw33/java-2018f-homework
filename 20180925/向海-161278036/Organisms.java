package confrontation;

import java.util.Scanner;

public class Organisms {
	public String name;
	public int x,y;
	public Organisms() {
		
	}
	public Organisms(String n) {
		this.name=n;
	}
	public String getName() {
		return name;
	}
	public void setXY(String[][] space,int x,int y) {
		space[x][y]=this.name;
		this.x=x;
		this.y=y;
	} 
}

class Grandpa extends Organisms{
	public Grandpa() {
		super("爷爷");
	}
	public void cheerUp() {
		
	}
}
class CalabashBrothers extends Organisms{
	public CalabashBrothers(String c) {
		this.name=c;
	}
	public void selectFormation(Formation formation) {
	
	}
}
class Sneak extends Organisms{
	public Sneak() {
		super("  蛇精   ");
	}
}
class Sorpio extends Organisms{
	public Sorpio() {
		super(" 蝎子精 ");
	}
	public void selectFormation(Formation formation,Sorpio sorpio,Lackeys[] lackeys,String[][] space) {
		Scanner in=new Scanner(System.in);
		System.out.println("蝎子精正在选择阵型");
		System.out.println("1、鹤翼");
		System.out.println("2、雁行");
		System.out.println("3、衡轭");
		System.out.println("4、长蛇");
		System.out.println("5、鱼鳞");
		System.out.println("6、方円");
		System.out.println("7、偃月");
		System.out.println("8、锋矢");
		int key=in.nextInt();
		switch(key) {
		case 1:formation.craneFormation(sorpio, lackeys, space);break;
		case 2:formation.echelonFormation(sorpio, lackeys, space);break;
		case 3:formation.yokeFormation(sorpio, lackeys, space);break;
		case 4:formation.sneakFormation(sorpio, lackeys, space);break;
		case 5:formation.fishFormation(sorpio, lackeys, space);break;
		case 6:formation.squareFormation(sorpio, lackeys, space);break;
		case 7:formation.moonFormation(sorpio, lackeys, space);break;
		case 8:formation.shapeFormation(sorpio, lackeys, space);break;
		}
		in.close();
	}
}
class Lackeys extends Organisms{
	public Lackeys() {
		super(" 小喽啰 ");
	}
}