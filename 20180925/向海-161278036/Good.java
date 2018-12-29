package confrontation;

class CalabashGuy extends Organisms{
	public String color;
	private int rank;
	public CalabashGuy(String name,String color,int rank) {
		this.name=name;
		this.color=color;
		this.rank=rank;
		this.type=1;
	}
	public void skill() {
		switch(rank) {
		
		}
	}
}
class CalabashBrothers{
	private int num=7;
	CalabashGuy[] calabashBrothers=new CalabashGuy[7];
	public CalabashBrothers() {
		calabashBrothers[0]=new CalabashGuy("老大","红色",1);
		calabashBrothers[1]=new CalabashGuy("老二","橙色",2);
		calabashBrothers[2]=new CalabashGuy("老三","黄色",3);
		calabashBrothers[3]=new CalabashGuy("老四","绿色",4);
		calabashBrothers[4]=new CalabashGuy("老五","青色",5);
		calabashBrothers[5]=new CalabashGuy("老六","蓝色",6);
		calabashBrothers[6]=new CalabashGuy("老七","紫色",7);
	}
	public int getNum() {
		return num;
	}
}
class Grandpa extends Organisms{
	public Grandpa() {
		super("爷爷");
		this.type=2;
	}
	public void cheerUp() {
		
	}
}
public class Good {
	Grandpa grandpa;
	CalabashBrothers calabash;
	Formation goodFormation;
	public Good() {
		grandpa=new Grandpa();
		calabash=new CalabashBrothers();
	}
	public void selectFormation(Battlefield battle) {
		//这里应该做一个选择
		goodFormation=new ChangShe();
		goodFormation.arrange(this, battle);
	}
}
