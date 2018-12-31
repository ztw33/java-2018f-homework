package confrontation;


/**
 * @see 预期有一个私有变量名字
 * @see String getName() 每个阵型的特定姓名
 * @see void arrange(Good good,Battlefield battle) 用来安排正义阵营的生物体位置
 * @see void arrange(Bad bad,Battlefield battle) 用来安排邪恶阵营的生物体位置
 */
interface Formation {
	public String getName();
	public void arrange(Good good,Battlefield battle);
	public void arrange(Bad bad,Battlefield battle);
}
class ChangShe implements Formation{
	private String name="长蛇";
	public String getName() {
		return this.name;
	}
	public void arrange(Good good,Battlefield battle) {
		good.grandpa.setPosition(battle.position, 0, 0);
		for(int i=0;i<good.calabash.getNum();i++) {
			good.calabash.calabashBrothers[i].setPosition(battle.position,8+i,10);
		}
	}
	public void arrange(Bad bad,Battlefield battle) {
		bad.sorpio.setPosition(battle.position, 8, 20);
		for(int i=0;i<=5;i++) {
			bad.LackeysList.add(new Lackeys());
			bad.LackeysList.get(i).setPosition(battle.position, 9+i, 20);
		}
		bad.sneak.setPosition(battle.position, 0, 29);
	}
}
class HeYi implements Formation{
	private String name="鹤翼";
	public String getName() {
		return this.name;
	}
	public void arrange(Good good ,Battlefield battle) {
		
	}
	public void arrange(Bad bad,Battlefield battle) {
		int cenX=11;
		int  cenY=20;
		bad.sorpio.setPosition(battle.position,cenX,cenY);
		bad.sneak.setPosition(battle.position, 0, 29);
		for(int i=0;i<=5;i++)
			bad.LackeysList.add(new Lackeys());
		bad.LackeysList.get(0).setPosition(battle.position, cenX-1, cenY+1);
		bad.LackeysList.get(1).setPosition(battle.position, cenX-1, cenY-1);
		bad.LackeysList.get(2).setPosition(battle.position, cenX-2, cenY+2);
		bad.LackeysList.get(3).setPosition(battle.position, cenX-2, cenY-2);
		bad.LackeysList.get(4).setPosition(battle.position, cenX-3, cenY+3);
		bad.LackeysList.get(5).setPosition(battle.position, cenX-3, cenY-3);
		
	}
}
class YanXing implements Formation{
	private String name="雁行";
	public String getName() {
		return name;
	}
	public void arrange(Good good,Battlefield battle) {
		
	}
	public void arrange(Bad bad,Battlefield battle) {
		int cenX=8;
		int cenY=20;
		bad.sorpio.setPosition(battle.position, cenX, cenY);
		bad.sneak.setPosition(battle.position, 0, 29);
		for(int i=0;i<=4;i++) {
			bad.LackeysList.add(new Lackeys());
			bad.LackeysList.get(i).setPosition(battle.position, cenX+i, cenY-i);	
		}
	}
}
class ChongE implements Formation{
	private String name="冲轭";
	public String getName() {
		return name;
	}
	public void arrange(Good good,Battlefield battle) {
		
	}
	public void arrange(Bad bad,Battlefield battle) {
		int cenX=8;
		int cenY=20;
		bad.sorpio.setPosition(battle.position, cenX, cenY);
		bad.sneak.setPosition(battle.position, 0, 29);
		for(int i=0;i<=5;i++) {
			bad.LackeysList.add(new Lackeys());
			if(i%2==0) {
				bad.LackeysList.get(i).setPosition(battle.position, cenX+i, cenY-1);
			}
			else if(i%2==1) {
				bad.LackeysList.get(i).setPosition(battle.position, cenX+i, cenY);
			}
		}
	}
}

class YuLing implements Formation{
	private String name="鱼鳞";
	public String getName() {
		return name;
	}
	public void arrange(Good good,Battlefield battle) {
		
	}
	public void arrange(Bad bad,Battlefield battle) {
		int cenX=11;
		int cenY=20;
		bad.sorpio.setPosition(battle.position, cenX, cenY);
		bad.sneak.setPosition(battle.position, 0, 29);
		for(int i=0;i<=8;i++)
			bad.LackeysList.add(new Lackeys());
		bad.LackeysList.get(0).setPosition(battle.position, cenX+1, cenY+1);
		for(int i=1;i<=3;i++)
			bad.LackeysList.get(i).setPosition(battle.position, cenX+2, cenY+i-2);
		for(int i=4;i<=7;i++)
			bad.LackeysList.get(i).setPosition(battle.position, cenX+3, cenY+i-6);
		bad.LackeysList.get(8).setPosition(battle.position, cenX+4, cenY);
	}
}
class FangYuan implements Formation{
	private String name="方円";
	public String getName() {
		return name;
	}
	public void arrange(Good good,Battlefield battle) {
		
	}
	public void arrange(Bad bad,Battlefield battle) {
		int cenX=11;
		int cenY=20;
		bad.sorpio.setPosition(battle.position, cenX, cenY);
		bad.sneak.setPosition(battle.position, 0, 29);
		for(int i=0;i<=6;i++)
			bad.LackeysList.add(new Lackeys());
		bad.LackeysList.get(0).setPosition(battle.position, cenX+1, cenY-1);
		bad.LackeysList.get(1).setPosition(battle.position, cenX+1, cenY+1);
		bad.LackeysList.get(2).setPosition(battle.position, cenX+2, cenY-2);
		bad.LackeysList.get(3).setPosition(battle.position, cenX+2, cenY+2);
		bad.LackeysList.get(4).setPosition(battle.position, cenX+3, cenY-1);
		bad.LackeysList.get(5).setPosition(battle.position, cenX+3, cenY+1);
		bad.LackeysList.get(6).setPosition(battle.position, cenX+4, cenY);
	}
}
class YanYue implements Formation{
	private String name="偃月";
	public String getName() {
		return name;
	}
	public void arrange(Good good, Battlefield battle) {
	
	}
	public void arrange(Bad bad, Battlefield battle) {
		int cenX=11;
		int cenY=20;
		bad.sorpio.setPosition(battle.position, cenX, cenY);
		bad.sneak.setPosition(battle.position, 0, 29);
		for(int i=0;i<=17;i++)
			bad.LackeysList.add(new Lackeys());
		for(int i=0,k=1;i<=1;i++,k++)
			bad.LackeysList.get(i).setPosition(battle.position, cenX, cenY+k);
		for(int i=2,k=0;i<=4;i++,k++)
			bad.LackeysList.get(i).setPosition(battle.position, cenX-1, cenY+k);
		for(int i=5,k=0;i<=7;i++,k++)
			bad.LackeysList.get(i).setPosition(battle.position, cenX+1, cenY+k);
		bad.LackeysList.get(8).setPosition(battle.position,cenX-2, cenY+1);
		bad.LackeysList.get(9).setPosition(battle.position,cenX-2, cenY+2);
		bad.LackeysList.get(10).setPosition(battle.position,cenX-3, cenY+2);
		bad.LackeysList.get(11).setPosition(battle.position,cenX-3, cenY+3);
		bad.LackeysList.get(12).setPosition(battle.position,cenX-4, cenY+4);
		
		bad.LackeysList.get(13).setPosition(battle.position,cenX+2, cenY+1);
		bad.LackeysList.get(14).setPosition(battle.position,cenX+2, cenY+2);
		bad.LackeysList.get(15).setPosition(battle.position,cenX+3, cenY+2);
		bad.LackeysList.get(16).setPosition(battle.position,cenX+3, cenY+3);
		bad.LackeysList.get(17).setPosition(battle.position,cenX+4, cenY+4);
	}
}
class FengShi implements Formation{
	private String name="锋矢";
	public String getName() {
		return name;
	}
	public void arrange(Good good, Battlefield battle) {
		
	}
	public void arrange(Bad bad,Battlefield battle) {
		int cenX=8;
		int cenY=25;
		bad.sorpio.setPosition(battle.position, cenX, cenY);
		bad.sneak.setPosition(battle.position, 0, 29);
		for(int i=0;i<=4;i++) {
			bad.LackeysList.add(new Lackeys());
			bad.LackeysList.get(i).setPosition(battle.position, cenX+1+i, cenY);
		}
		for(int i=5,k=1;i<=7;i++,k++) {
			bad.LackeysList.add(new Lackeys());
			bad.LackeysList.get(i).setPosition(battle.position, cenX+k, cenY-k);
		}
		for(int i=8,k=1;i<=10;i++,k++) {
			bad.LackeysList.add(new Lackeys());
			bad.LackeysList.get(i).setPosition(battle.position, cenX+k, cenY+k);
		}
		
	}
}